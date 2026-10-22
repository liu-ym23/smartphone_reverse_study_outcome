package androidx.room;

import ai.j0;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.exifinterface.media.ExifInterface;
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
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 p2\u00020\u0001:\u0007nopqrstB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010:\u001a\u00020;H\u0017J\b\u0010<\u001a\u00020;H\u0017J\b\u0010=\u001a\u00020;H\u0017J\b\u0010>\u001a\u00020;H'J\b\u0010?\u001a\u00020;H\u0016J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0010H\u0016J\b\u0010C\u001a\u00020\u0018H$J\u0010\u0010D\u001a\u00020\u00132\u0006\u0010E\u001a\u00020FH$J\b\u0010G\u001a\u00020;H\u0017J*\u0010H\u001a\b\u0012\u0004\u0012\u00020I0#2\u001a\u0010\u0007\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\n0JH\u0017J\r\u0010K\u001a\u00020LH\u0000¢\u0006\u0002\bMJ\u0016\u0010N\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t0OH\u0017J\"\u0010P\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0#0JH\u0015J#\u0010Q\u001a\u0004\u0018\u0001HR\"\u0004\b\u0000\u0010R2\f\u0010S\u001a\b\u0012\u0004\u0012\u0002HR0\tH\u0016¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u00020\u0004H\u0016J\u0010\u0010V\u001a\u00020;2\u0006\u0010W\u001a\u00020FH\u0017J\b\u0010X\u001a\u00020;H\u0002J\b\u0010Y\u001a\u00020;H\u0002J\u0010\u0010Z\u001a\u00020;2\u0006\u0010[\u001a\u00020'H\u0014J\u001c\u0010\\\u001a\u00020]2\u0006\u0010\\\u001a\u00020^2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010`H\u0017J)\u0010\\\u001a\u00020]2\u0006\u0010\\\u001a\u00020\u00102\u0012\u0010a\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010bH\u0016¢\u0006\u0002\u0010cJ\u0010\u0010d\u001a\u00020;2\u0006\u0010e\u001a\u00020fH\u0016J!\u0010d\u001a\u0002Hg\"\u0004\b\u0000\u0010g2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002Hg0hH\u0016¢\u0006\u0002\u0010iJ\b\u0010j\u001a\u00020;H\u0017J+\u0010k\u001a\u0004\u0018\u0001HR\"\u0004\b\u0000\u0010R2\f\u0010l\u001a\b\u0012\u0004\u0012\u0002HR0\t2\u0006\u0010)\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010mR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u0007\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\n0\b8\u0004@\u0004X\u0085\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001f\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\b8G¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u00048VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b\u001e\u0010\u001dR\u0017\u0010 \u001a\u00020\u00048G¢\u0006\f\u0012\u0004\b!\u0010\u0002\u001a\u0004\b \u0010\u001dR \u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#8\u0004@\u0004X\u0085\u000e¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u0002R\u001a\u0010&\u001a\u0004\u0018\u00010'8\u0004@\u0004X\u0085\u000e¢\u0006\b\n\u0000\u0012\u0004\b(\u0010\u0002R\u0014\u0010)\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u00101\u001a\b\u0012\u0004\u0012\u000203028G¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010.R\u001e\u00108\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Landroidx/room/RoomDatabase;", "", "()V", "allowMainThreadQueries", "", "autoCloser", "Landroidx/room/AutoCloser;", "autoMigrationSpecs", "", "Ljava/lang/Class;", "Landroidx/room/migration/AutoMigrationSpec;", "getAutoMigrationSpecs", "()Ljava/util/Map;", "setAutoMigrationSpecs", "(Ljava/util/Map;)V", "backingFieldMap", "", "getBackingFieldMap", "internalOpenHelper", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "internalQueryExecutor", "Ljava/util/concurrent/Executor;", "internalTransactionExecutor", "invalidationTracker", "Landroidx/room/InvalidationTracker;", "getInvalidationTracker", "()Landroidx/room/InvalidationTracker;", "isMainThread", "isMainThread$room_runtime_release", "()Z", "isOpen", "isOpen$annotations", "isOpenInternal", "isOpenInternal$annotations", "mCallbacks", "", "Landroidx/room/RoomDatabase$Callback;", "getMCallbacks$annotations", "mDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getMDatabase$annotations", "openHelper", "getOpenHelper", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "queryExecutor", "getQueryExecutor", "()Ljava/util/concurrent/Executor;", "readWriteLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "suspendingTransactionId", "Ljava/lang/ThreadLocal;", "", "getSuspendingTransactionId", "()Ljava/lang/ThreadLocal;", "transactionExecutor", "getTransactionExecutor", "typeConverters", "writeAheadLoggingEnabled", "assertNotMainThread", "", "assertNotSuspendingTransaction", "beginTransaction", "clearAllTables", "close", "compileStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sql", "createInvalidationTracker", "createOpenHelper", "config", "Landroidx/room/DatabaseConfiguration;", "endTransaction", "getAutoMigrations", "Landroidx/room/migration/Migration;", "", "getCloseLock", "Ljava/util/concurrent/locks/Lock;", "getCloseLock$room_runtime_release", "getRequiredAutoMigrationSpecs", "", "getRequiredTypeConverters", "getTypeConverter", ExifInterface.GPS_DIRECTION_TRUE, "klass", "(Ljava/lang/Class;)Ljava/lang/Object;", "inTransaction", "init", "configuration", "internalBeginTransaction", "internalEndTransaction", "internalInitInvalidationTracker", "db", "query", "Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "signal", "Landroid/os/CancellationSignal;", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "runInTransaction", "body", "Ljava/lang/Runnable;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)Ljava/lang/Object;", "setTransactionSuccessful", "unwrapOpenHelper", "clazz", "(Ljava/lang/Class;Landroidx/sqlite/db/SupportSQLiteOpenHelper;)Ljava/lang/Object;", "Builder", "Callback", "Companion", "JournalMode", "MigrationContainer", "PrepackagedDatabaseCallback", "QueryCallback", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    @Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0002\b\u000b\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B'\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00104\u001a\u00020\u0014H\u0016J\u0016\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00106\u001a\u00020\u0016H\u0016J'\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u00020:09\"\u00020:H\u0016¢\u0006\u0002\u0010;J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010=\u001a\u00020\u0003H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\r\u0010>\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010?J\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010A\u001a\u00020\tH\u0016J\u001e\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010A\u001a\u00020\t2\u0006\u00106\u001a\u00020*H\u0017J\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010C\u001a\u00020\u0019H\u0016J\u001e\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010C\u001a\u00020\u00192\u0006\u00106\u001a\u00020*H\u0017J\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0017J$\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u00106\u001a\u00020*H\u0017J\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\u0010I\u001a\u00020J\"\u00020%H\u0016J\u000e\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u0018\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J \u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0001\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u0016\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010P\u001a\u00020(H\u0017J\u001e\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010R\u001a\u00020.H\u0016J\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010R\u001a\u00020.H\u0016J\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010R\u001a\u00020.H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Landroidx/room/RoomDatabase$Builder;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/RoomDatabase;", "", "context", "Landroid/content/Context;", "klass", "Ljava/lang/Class;", "name", "", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;)V", "allowDestructiveMigrationOnDowngrade", "", "allowMainThreadQueries", "autoCloseTimeUnit", "Ljava/util/concurrent/TimeUnit;", "autoCloseTimeout", "", "autoMigrationSpecs", "", "Landroidx/room/migration/AutoMigrationSpec;", "callbacks", "Landroidx/room/RoomDatabase$Callback;", "copyFromAssetPath", "copyFromFile", "Ljava/io/File;", "copyFromInputStream", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "factory", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "journalMode", "Landroidx/room/RoomDatabase$JournalMode;", "migrationContainer", "Landroidx/room/RoomDatabase$MigrationContainer;", "migrationStartAndEndVersions", "", "", "migrationsNotRequiredFrom", "multiInstanceInvalidationIntent", "Landroid/content/Intent;", "prepackagedDatabaseCallback", "Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;", "queryCallback", "Landroidx/room/RoomDatabase$QueryCallback;", "queryCallbackExecutor", "Ljava/util/concurrent/Executor;", "queryExecutor", "requireMigration", "transactionExecutor", "typeConverters", "addAutoMigrationSpec", "autoMigrationSpec", "addCallback", "callback", "addMigrations", "migrations", "", "Landroidx/room/migration/Migration;", "([Landroidx/room/migration/Migration;)Landroidx/room/RoomDatabase$Builder;", "addTypeConverter", "typeConverter", "build", "()Landroidx/room/RoomDatabase;", "createFromAsset", "databaseFilePath", "createFromFile", "databaseFile", "createFromInputStream", "inputStreamCallable", "enableMultiInstanceInvalidation", "fallbackToDestructiveMigration", "fallbackToDestructiveMigrationFrom", "startVersions", "", "fallbackToDestructiveMigrationOnDowngrade", "openHelperFactory", "setAutoCloseTimeout", "setJournalMode", "setMultiInstanceInvalidationServiceIntent", "invalidationServiceIntent", "setQueryCallback", "executor", "setQueryExecutor", "setTransactionExecutor", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

        public Builder(Context r5, Class<T> r10, String r11) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r10, "klass");
            this.context = r5;
            this.klass = r10;
            this.name = r11;
            this.callbacks = new ArrayList();
            this.typeConverters = new ArrayList();
            this.autoMigrationSpecs = new ArrayList();
            this.journalMode = JournalMode.AUTOMATIC;
            this.requireMigration = true;
            this.autoCloseTimeout = -1;
            this.migrationContainer = new MigrationContainer();
            this.migrationsNotRequiredFrom = new LinkedHashSet();
        }

        public Builder<T> addAutoMigrationSpec(AutoMigrationSpec r5) {
            Intrinsics.checkNotNullParameter(r5, "autoMigrationSpec");
            this.autoMigrationSpecs.add(r5);
            return this;
        }

        public Builder<T> addCallback(Callback r5) {
            Intrinsics.checkNotNullParameter(r5, "callback");
            this.callbacks.add(r5);
            return this;
        }

        public Builder<T> addMigrations(Migration... r10) {
            Intrinsics.checkNotNullParameter(r10, "migrations");
            if (this.migrationStartAndEndVersions != null) goto L5;
            this.migrationStartAndEndVersions = new HashSet();
        L5:
            int r5 = r10.length;
            int r11 = 0;
        L6:
            if (r11 >= r5) goto L8;
            Migration r12 = r10[r11];
            Set<Integer> r13 = this.migrationStartAndEndVersions;
            Intrinsics.checkNotNull(r13);
            r13.add(Integer.valueOf(r12.startVersion));
            Set<Integer> r14 = this.migrationStartAndEndVersions;
            Intrinsics.checkNotNull(r14);
            r14.add(Integer.valueOf(r12.endVersion));
            r11 = r11 + 1;
            goto L6
        L8:
            this.migrationContainer.addMigrations((Migration[]) Arrays.copyOf(r10, r10.length));
            return this;
        }

        public Builder<T> addTypeConverter(Object r5) {
            Intrinsics.checkNotNullParameter(r5, "typeConverter");
            this.typeConverters.add(r5);
            return this;
        }

        public Builder<T> allowMainThreadQueries() {
            this.allowMainThreadQueries = true;
            return this;
        }

        public T build() {
            Executor r5 = this.queryExecutor;
            if (r5 == null) goto L5;
        L7:
            if (r5 != null) goto L9;
        L11:
            if (r5 != null) goto L13;
            this.queryExecutor = this.transactionExecutor;
        L13:
            Set<Integer> r10 = this.migrationStartAndEndVersions;
            if (r10 == null) goto L23;
            Intrinsics.checkNotNull(r10);
            Iterator<Integer> r11 = r10.iterator();
        L17:
            if (r11.hasNext() == false) goto L23;
            int r12 = r11.next().intValue();
            if (this.migrationsNotRequiredFrom.contains(Integer.valueOf(r12)) == false) goto L17;
            throw new IllegalArgumentException(j0.g(r12, "Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: ").toString());
        L23:
            SupportSQLiteOpenHelper.Factory r13 = this.factory;
            if (r13 != null) goto L27;
            r13 = new FrameworkSQLiteOpenHelperFactory();
        L27:
            if (r13 != null) goto L29;
            r13 = null;
        L71:
            if (r13 == null) goto L94;
            QueryCallback r14 = this.queryCallback;
            if (r14 == null) goto L82;
            Executor r15 = this.queryCallbackExecutor;
            if (r15 == null) goto L81;
            if (r14 == null) goto L79;
            SupportSQLiteOpenHelper.Factory r16 = new QueryInterceptorOpenHelperFactory(r13, r15, r14);
        L83:
            Context r17 = this.context;
            String r18 = this.name;
            MigrationContainer r19 = this.migrationContainer;
            List<Callback> r20 = this.callbacks;
            boolean r21 = this.allowMainThreadQueries;
            JournalMode r110 = this.journalMode.resolve$room_runtime_release(r17);
            Executor r111 = this.queryExecutor;
            if (r111 == null) goto L92;
            Executor r112 = this.transactionExecutor;
            if (r112 == null) goto L90;
            DatabaseConfiguration r22 = new DatabaseConfiguration(r17, r18, r16, r19, r20, r21, r110, r111, r112, this.multiInstanceInvalidationIntent, this.requireMigration, this.allowDestructiveMigrationOnDowngrade, this.migrationsNotRequiredFrom, this.copyFromAssetPath, this.copyFromFile, this.copyFromInputStream, this.prepackagedDatabaseCallback, this.typeConverters, this.autoMigrationSpecs);
            T r23 = (T) Room.getGeneratedImplementation(this.klass, "_Impl");
            r23.init(r22);
            return r23;
        L90:
            throw new IllegalArgumentException("Required value was null.");
        L92:
            throw new IllegalArgumentException("Required value was null.");
        L79:
            throw new IllegalArgumentException("Required value was null.");
        L81:
            throw new IllegalArgumentException("Required value was null.");
        L82:
            r16 = r13;
            goto L83
        L94:
            throw new IllegalArgumentException("Required value was null.");
        L29:
            if (this.autoCloseTimeout > 0) goto L31;
        L43:
            String r24 = this.copyFromAssetPath;
            if (r24 != null) goto L50;
            if (this.copyFromFile != null) goto L50;
            if (this.copyFromInputStream == null) goto L71;
        L50:
            if (this.name == null) goto L69;
            int r25 = 0;
            if (r24 != null) goto L54;
            int r26 = 0;
        L55:
            File r27 = this.copyFromFile;
            if (r27 != null) goto L58;
            int r28 = 0;
        L59:
            Callable<InputStream> r29 = this.copyFromInputStream;
            if (r29 == null) goto L64;
            r25 = 1;
        L64:
            if (((r26 + r28) + r25) != 1) goto L67;
            r13 = new SQLiteCopyOpenHelperFactory(r24, r27, r29, r13);
            goto L71
        L67:
            throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
        L58:
            r28 = 1;
            goto L59
        L54:
            r26 = 1;
            goto L55
        L69:
            throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
        L31:
            if (this.name == null) goto L42;
            long r30 = this.autoCloseTimeout;
            TimeUnit r31 = this.autoCloseTimeUnit;
            if (r31 == null) goto L40;
            Executor r32 = this.queryExecutor;
            if (r32 == null) goto L38;
            r13 = new AutoClosingRoomOpenHelperFactory(r13, new AutoCloser(r30, r31, r32));
            goto L43
        L38:
            throw new IllegalArgumentException("Required value was null.");
        L40:
            throw new IllegalArgumentException("Required value was null.");
        L42:
            throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
        L9:
            if (this.transactionExecutor != null) goto L11;
            this.transactionExecutor = r5;
            goto L13
        L5:
            if (this.transactionExecutor != null) goto L7;
            Executor r33 = ArchTaskExecutor.getIOThreadExecutor();
            this.transactionExecutor = r33;
            this.queryExecutor = r33;
            goto L13
        }

        public Builder<T> createFromAsset(String r5) {
            Intrinsics.checkNotNullParameter(r5, "databaseFilePath");
            this.copyFromAssetPath = r5;
            return this;
        }

        public Builder<T> createFromFile(File r5) {
            Intrinsics.checkNotNullParameter(r5, "databaseFile");
            this.copyFromFile = r5;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder<T> createFromInputStream(Callable<InputStream> r5) {
            Intrinsics.checkNotNullParameter(r5, "inputStreamCallable");
            this.copyFromInputStream = r5;
            return this;
        }

        public Builder<T> enableMultiInstanceInvalidation() {
            if (this.name == null) goto L5;
            Intent r5 = new Intent(this.context, MultiInstanceInvalidationService.class);
        L6:
            this.multiInstanceInvalidationIntent = r5;
            return this;
        L5:
            r5 = null;
            goto L6
        }

        public Builder<T> fallbackToDestructiveMigration() {
            this.requireMigration = false;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationFrom(int... r5) {
            Intrinsics.checkNotNullParameter(r5, "startVersions");
            int r10 = r5.length;
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            int r12 = r5[r11];
            this.migrationsNotRequiredFrom.add(Integer.valueOf(r12));
            r11 = r11 + 1;
            goto L3
        L5:
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            this.requireMigration = true;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> openHelperFactory(SupportSQLiteOpenHelper.Factory r5) {
            this.factory = r5;
            return this;
        }

        @ExperimentalRoomApi
        public Builder<T> setAutoCloseTimeout(@IntRange(from = 0) long r5, TimeUnit r10) {
            Intrinsics.checkNotNullParameter(r10, "autoCloseTimeUnit");
            if (r5 < 0) goto L7;
            this.autoCloseTimeout = r5;
            this.autoCloseTimeUnit = r10;
            return this;
        L7:
            throw new IllegalArgumentException("autoCloseTimeout must be >= 0");
        }

        public Builder<T> setJournalMode(JournalMode r5) {
            Intrinsics.checkNotNullParameter(r5, "journalMode");
            this.journalMode = r5;
            return this;
        }

        @ExperimentalRoomApi
        public Builder<T> setMultiInstanceInvalidationServiceIntent(Intent r5) {
            Intrinsics.checkNotNullParameter(r5, "invalidationServiceIntent");
            if (this.name != null) goto L6;
            r5 = null;
        L6:
            this.multiInstanceInvalidationIntent = r5;
            return this;
        }

        public Builder<T> setQueryCallback(QueryCallback r5, Executor r10) {
            Intrinsics.checkNotNullParameter(r5, "queryCallback");
            Intrinsics.checkNotNullParameter(r10, "executor");
            this.queryCallback = r5;
            this.queryCallbackExecutor = r10;
            return this;
        }

        public Builder<T> setQueryExecutor(Executor r5) {
            Intrinsics.checkNotNullParameter(r5, "executor");
            this.queryExecutor = r5;
            return this;
        }

        public Builder<T> setTransactionExecutor(Executor r5) {
            Intrinsics.checkNotNullParameter(r5, "executor");
            this.transactionExecutor = r5;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder<T> createFromAsset(String r5, PrepackagedDatabaseCallback r10) {
            Intrinsics.checkNotNullParameter(r5, "databaseFilePath");
            Intrinsics.checkNotNullParameter(r10, "callback");
            this.prepackagedDatabaseCallback = r10;
            this.copyFromAssetPath = r5;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "StreamFiles"})
        public Builder<T> createFromFile(File r5, PrepackagedDatabaseCallback r10) {
            Intrinsics.checkNotNullParameter(r5, "databaseFile");
            Intrinsics.checkNotNullParameter(r10, "callback");
            this.prepackagedDatabaseCallback = r10;
            this.copyFromFile = r5;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "LambdaLast"})
        public Builder<T> createFromInputStream(Callable<InputStream> r5, PrepackagedDatabaseCallback r10) {
            Intrinsics.checkNotNullParameter(r5, "inputStreamCallable");
            Intrinsics.checkNotNullParameter(r10, "callback");
            this.prepackagedDatabaseCallback = r10;
            this.copyFromInputStream = r5;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Landroidx/room/RoomDatabase$Callback;", "", "()V", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "onDestructiveMigration", "onOpen", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class Callback {
        public Callback() {
        }

        public void onCreate(SupportSQLiteDatabase r5) {
            Intrinsics.checkNotNullParameter(r5, "db");
        }

        public void onDestructiveMigration(SupportSQLiteDatabase r5) {
            Intrinsics.checkNotNullParameter(r5, "db");
        }

        public void onOpen(SupportSQLiteDatabase r5) {
            Intrinsics.checkNotNullParameter(r5, "db");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/RoomDatabase$Companion;", "", "()V", "MAX_BIND_PARAMETER_CNT", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Landroidx/room/RoomDatabase$JournalMode;", "", "(Ljava/lang/String;I)V", "isLowRamDevice", "", "activityManager", "Landroid/app/ActivityManager;", "resolve", "context", "Landroid/content/Context;", "resolve$room_runtime_release", "AUTOMATIC", "TRUNCATE", "WRITE_AHEAD_LOGGING", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

        private JournalMode(String r5, int r10) {
            super(r5, r10);
        }

        private final boolean isLowRamDevice(ActivityManager r5) {
            return SupportSQLiteCompat.Api19Impl.isLowRamDevice(r5);
        }

        public static JournalMode valueOf(String r5) {
            return (JournalMode) Enum.valueOf(JournalMode.class, r5);
        }

        public static JournalMode[] values() {
            return (JournalMode[]) $VALUES.clone();
        }

        public final JournalMode resolve$room_runtime_release(Context r5) {
            Intrinsics.checkNotNullParameter(r5, "context");
            if (this == AUTOMATIC) goto L5;
            return this;
        L5:
            Object r10 = r5.getSystemService("activity");
            if ((r10 instanceof ActivityManager) == false) goto L8;
            ActivityManager r11 = (ActivityManager) r10;
        L9:
            if (r11 == null) goto L15;
            if (isLowRamDevice(r11) == true) goto L15;
            return WRITE_AHEAD_LOGGING;
        L15:
            return TRUNCATE;
        L8:
            r11 = null;
            goto L9
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002J!\u0010\u000b\u001a\u00020\t2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\f\"\u00020\u0007H\u0016¢\u0006\u0002\u0010\rJ\u0016\u0010\u000b\u001a\u00020\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J \u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J6\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J \u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u001b0\u001bH\u0016R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/room/RoomDatabase$MigrationContainer;", "", "()V", "migrations", "", "", "Ljava/util/TreeMap;", "Landroidx/room/migration/Migration;", "addMigration", "", "migration", "addMigrations", "", "([Landroidx/room/migration/Migration;)V", "", "contains", "", "startVersion", "endVersion", "findMigrationPath", "start", "end", "findUpMigrationPath", "result", "", "upgrade", "getMigrations", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class MigrationContainer {
        private final Map<Integer, TreeMap<Integer, Migration>> migrations;

        public MigrationContainer() {
            this.migrations = new LinkedHashMap();
        }

        private final void addMigration(Migration r5) {
            int r10 = r5.startVersion;
            int r11 = r5.endVersion;
            Map<Integer, TreeMap<Integer, Migration>> r12 = this.migrations;
            Integer r13 = Integer.valueOf(r10);
            TreeMap<Integer, Migration> r14 = r12.get(r13);
            if (r14 != null) goto L5;
            r14 = new TreeMap();
            r12.put(r13, r14);
        L5:
            TreeMap<Integer, Migration> r15 = r14;
            if (r15.containsKey(Integer.valueOf(r11)) == false) goto L8;
            Log.w(Room.LOG_TAG, "Overriding migration " + r15.get(Integer.valueOf(r11)) + " with " + r5);
        L8:
            r15.put(Integer.valueOf(r11), r5);
        }

        private final List<Migration> findUpMigrationPath(List<Migration> r10, boolean r11, int r12, int r13) {
        L2:
            if (r11 == false) goto L5;
            if (r12 >= r13) goto L28;
        L6:
            TreeMap<Integer, Migration> r5 = this.migrations.get(Integer.valueOf(r12));
            if (r5 == null) goto L8;
            if (r11 == false) goto L11;
            Set<Integer> r14 = r5.descendingKeySet();
        L12:
            Iterator<Integer> r15 = r14.iterator();
        L14:
            if (r15.hasNext() == false) goto L25;
            Integer r16 = r15.next();
            if (r11 == true) goto L17;
            int r17 = r16.intValue();
            if (r13 > r17) goto L14;
            if (r17 >= r12) goto L14;
        L24:
            Migration r18 = r5.get(r16);
            Intrinsics.checkNotNull(r18);
            r10.add(r18);
            r12 = r16.intValue();
            boolean r19 = true;
        L26:
            if (r19 == true) goto L2;
            return null;
        L17:
            int r20 = r12 + 1;
            int r21 = r16.intValue();
            if (r20 > r21) goto L14;
            if (r21 > r13) goto L14;
        L25:
            r19 = false;
            goto L26
        L11:
            r14 = r5.keySet();
            goto L12
        L8:
            return null;
        L28:
            return r10;
        L5:
            if (r12 <= r13) goto L28;
            goto L6
        }

        public void addMigrations(Migration... r5) {
            Intrinsics.checkNotNullParameter(r5, "migrations");
            int r10 = r5.length;
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            addMigration(r5[r11]);
            r11 = r11 + 1;
            goto L3
        }

        public final boolean contains(int r5, int r10) {
            Map<Integer, Map<Integer, Migration>> r11 = getMigrations();
            if (r11.containsKey(Integer.valueOf(r5)) == false) goto L9;
            Map<Integer, Migration> r12 = r11.get(Integer.valueOf(r5));
            if (r12 != null) goto L8;
            r12 = MapsKt.emptyMap();
        L8:
            return r12.containsKey(Integer.valueOf(r10));
        L9:
            return false;
        }

        public List<Migration> findMigrationPath(int r5, int r10) {
            if (r5 == r10) goto L4;
            if (r10 <= r5) goto L7;
            boolean r11 = true;
        L9:
            return findUpMigrationPath(new ArrayList(), r11, r5, r10);
        L7:
            r11 = false;
            goto L9
        L4:
            return CollectionsKt.emptyList();
        }

        public Map<Integer, Map<Integer, Migration>> getMigrations() {
            return this.migrations;
        }

        public void addMigrations(List<? extends Migration> r5) {
            Intrinsics.checkNotNullParameter(r5, "migrations");
            Iterator<T> r10 = r5.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            addMigration((Migration) r10.next());
            goto L4
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;", "", "()V", "onOpenPrepackagedDatabase", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class PrepackagedDatabaseCallback {
        public PrepackagedDatabaseCallback() {
        }

        public void onOpenPrepackagedDatabase(SupportSQLiteDatabase r5) {
            Intrinsics.checkNotNullParameter(r5, "db");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/room/RoomDatabase$QueryCallback;", "", "onQuery", "", "sqlQuery", "", "bindArgs", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface QueryCallback {
        void onQuery(String r5, List<? extends Object> r10);
    }

    static {
        Companion = new Companion(null);
    }

    public RoomDatabase() {
        this.invalidationTracker = createInvalidationTracker();
        this.autoMigrationSpecs = new LinkedHashMap();
        this.readWriteLock = new ReentrantReadWriteLock();
        this.suspendingTransactionId = new ThreadLocal();
        this.backingFieldMap = Collections.synchronizedMap(new LinkedHashMap());
        this.typeConverters = new LinkedHashMap();
    }

    public static final /* synthetic */ void access$internalBeginTransaction(RoomDatabase r5) {
        r5.internalBeginTransaction();
    }

    public static final /* synthetic */ void access$internalEndTransaction(RoomDatabase r5) {
        r5.internalEndTransaction();
    }

    @Deprecated(message = "Will be hidden in a future release.")
    public static /* synthetic */ void getMCallbacks$annotations() {
    }

    @Deprecated(message = "Will be hidden in the next release.")
    public static /* synthetic */ void getMDatabase$annotations() {
    }

    private final void internalBeginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase r5 = getOpenHelper().getWritableDatabase();
        getInvalidationTracker().syncTriggers$room_runtime_release(r5);
        if (r5.isWriteAheadLoggingEnabled() == false) goto L5;
        r5.beginTransactionNonExclusive();
        return;
    L5:
        r5.beginTransaction();
    }

    private final void internalEndTransaction() {
        getOpenHelper().getWritableDatabase().endTransaction();
        if (inTransaction() == true) goto L6;
        getInvalidationTracker().refreshVersionsAsync();
        return;
    }

    public static /* synthetic */ void isOpen$annotations() {
    }

    public static /* synthetic */ void isOpenInternal$annotations() {
    }

    public static /* synthetic */ Cursor query$default(RoomDatabase r5, SupportSQLiteQuery r10, CancellationSignal r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 2) == 0) goto L7;
        r11 = null;
    L7:
        return r5.query(r10, r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> T unwrapOpenHelper(Class<T> r5, SupportSQLiteOpenHelper r10) {
        if (r5.isInstance(r10) == false) goto L6;
        return r10;
    L6:
        if ((r10 instanceof DelegatingOpenHelper) == true) goto L10;
        return null;
    L10:
        return (T) unwrapOpenHelper(r5, ((DelegatingOpenHelper) r10).getDelegate());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void assertNotMainThread() {
        if (this.allowMainThreadQueries == false) goto L6;
        return;
    L6:
        if (isMainThread$room_runtime_release() == true) goto L9;
        return;
    L9:
        throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void assertNotSuspendingTransaction() {
        if (inTransaction() == false) goto L5;
        return;
    L5:
        if (this.suspendingTransactionId.get() != null) goto L8;
        return;
    L8:
        throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
    }

    @Deprecated(message = "beginTransaction() is deprecated", replaceWith = @ReplaceWith(expression = "runInTransaction(Runnable)", imports = {}))
    public void beginTransaction() {
        assertNotMainThread();
        AutoCloser r5 = this.autoCloser;
        if (r5 != null) goto L5;
        internalBeginTransaction();
        return;
    L5:
        r5.executeRefCountingFunction(new AnonymousClass1(this));
    }

    @WorkerThread
    public abstract void clearAllTables();

    public void close() {
        if (isOpen() == false) goto L10;
        ReentrantReadWriteLock.WriteLock r5 = this.readWriteLock.writeLock();
        r5.lock();
        getInvalidationTracker().stopMultiInstanceInvalidation$room_runtime_release();     // Catch: Throwable -> L7
        getOpenHelper().close();     // Catch: Throwable -> L7
        r5.unlock();
        return;
    L7:
        th = move-exception;
        r5.unlock();
        throw th;
    }

    public SupportSQLiteStatement compileStatement(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sql");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().compileStatement(r5);
    }

    public abstract InvalidationTracker createInvalidationTracker();

    public abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r5);

    @Deprecated(message = "endTransaction() is deprecated", replaceWith = @ReplaceWith(expression = "runInTransaction(Runnable)", imports = {}))
    public void endTransaction() {
        AutoCloser r5 = this.autoCloser;
        if (r5 != null) goto L5;
        internalEndTransaction();
        return;
    L5:
        r5.executeRefCountingFunction(new C00961(this));
    }

    public final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> getAutoMigrationSpecs() {
        return this.autoMigrationSpecs;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @JvmSuppressWildcards
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r5) {
        Intrinsics.checkNotNullParameter(r5, "autoMigrationSpecs");
        return CollectionsKt.emptyList();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Map<String, Object> getBackingFieldMap() {
        return this.backingFieldMap;
    }

    public final Lock getCloseLock$room_runtime_release() {
        return this.readWriteLock.readLock();
    }

    public InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    public SupportSQLiteOpenHelper getOpenHelper() {
        SupportSQLiteOpenHelper r5 = this.internalOpenHelper;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("internalOpenHelper");
        return null;
    L6:
        return r5;
    }

    public Executor getQueryExecutor() {
        Executor r5 = this.internalQueryExecutor;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("internalQueryExecutor");
        return null;
    L6:
        return r5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return SetsKt.emptySet();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return MapsKt.emptyMap();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.suspendingTransactionId;
    }

    public Executor getTransactionExecutor() {
        Executor r5 = this.internalTransactionExecutor;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("internalTransactionExecutor");
        return null;
    L6:
        return r5;
    }

    public <T> T getTypeConverter(Class<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "klass");
        return (T) this.typeConverters.get(r5);
    }

    public boolean inTransaction() {
        return getOpenHelper().getWritableDatabase().inTransaction();
    }

    @CallSuper
    public void init(DatabaseConfiguration r10) {
        Intrinsics.checkNotNullParameter(r10, "configuration");
        this.internalOpenHelper = createOpenHelper(r10);
        Set<Class<? extends AutoMigrationSpec>> r5 = getRequiredAutoMigrationSpecs();
        BitSet r11 = new BitSet();
        Iterator<Class<? extends AutoMigrationSpec>> r12 = r5.iterator();
    L3:
        int r13 = -1;
        if (r12.hasNext() == false) goto L17;
        Class<? extends AutoMigrationSpec> r14 = r12.next();
        int r15 = r10.autoMigrationSpecs.size() - 1;
        if (r15 < 0) goto L13;
    L7:
        int r16 = r15 - 1;
        if (r14.isAssignableFrom(r10.autoMigrationSpecs.get(r15).getClass()) == true) goto L9;
        if (r16 < 0) goto L13;
        r15 = r16;
        goto L7
    L9:
        r11.set(r15);
        r13 = r15;
    L13:
        if (r13 < 0) goto L16;
        this.autoMigrationSpecs.put(r14, r10.autoMigrationSpecs.get(r13));
        goto L3
    L16:
        throw new IllegalArgumentException(("A required auto migration spec (" + r14.getCanonicalName() + ") is missing in the database configuration.").toString());
    L17:
        int r17 = r10.autoMigrationSpecs.size() - 1;
        if (r17 < 0) goto L26;
    L19:
        int r18 = r17 - 1;
        if (r11.get(r17) == false) goto L25;
        if (r18 < 0) goto L26;
        r17 = r18;
        goto L19
    L25:
        throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
    L26:
        Iterator<Migration> r19 = getAutoMigrations(this.autoMigrationSpecs).iterator();
    L28:
        if (r19.hasNext() == false) goto L32;
        Migration r20 = r19.next();
        if (r10.migrationContainer.contains(r20.startVersion, r20.endVersion) == true) goto L28;
        r10.migrationContainer.addMigrations(new Migration[]{r20});
        goto L28
    L32:
        SQLiteCopyOpenHelper r21 = (SQLiteCopyOpenHelper) unwrapOpenHelper(SQLiteCopyOpenHelper.class, getOpenHelper());
        if (r21 == null) goto L35;
        r21.setDatabaseConfiguration(r10);
    L35:
        AutoClosingRoomOpenHelper r22 = (AutoClosingRoomOpenHelper) unwrapOpenHelper(AutoClosingRoomOpenHelper.class, getOpenHelper());
        if (r22 == null) goto L39;
        this.autoCloser = r22.autoCloser;
        getInvalidationTracker().setAutoCloser$room_runtime_release(r22.autoCloser);
    L39:
        if (r10.journalMode != JournalMode.WRITE_AHEAD_LOGGING) goto L41;
        boolean r23 = true;
    L42:
        getOpenHelper().setWriteAheadLoggingEnabled(r23);
        this.mCallbacks = r10.callbacks;
        this.internalQueryExecutor = r10.queryExecutor;
        this.internalTransactionExecutor = new TransactionExecutor(r10.transactionExecutor);
        this.allowMainThreadQueries = r10.allowMainThreadQueries;
        this.writeAheadLoggingEnabled = r23;
        if (r10.multiInstanceInvalidationServiceIntent != null) goto L45;
    L49:
        Map<Class<?>, List<Class<?>>> r24 = getRequiredTypeConverters();
        BitSet r25 = new BitSet();
        Iterator<Map.Entry<Class<?>, List<Class<?>>>> r26 = r24.entrySet().iterator();
    L51:
        if (r26.hasNext() == false) goto L68;
        Map.Entry<Class<?>, List<Class<?>>> r27 = r26.next();
        Class<?> r28 = r27.getKey();
        Iterator<Class<?>> r29 = r27.getValue().iterator();
    L54:
        if (r29.hasNext() == false) goto L51;
        Class<?> r30 = r29.next();
        int r31 = r10.typeConverters.size() - 1;
        if (r31 < 0) goto L63;
    L57:
        int r32 = r31 - 1;
        if (r30.isAssignableFrom(r10.typeConverters.get(r31).getClass()) == true) goto L59;
        if (r32 < 0) goto L63;
        r31 = r32;
        goto L57
    L59:
        r25.set(r31);
    L64:
        if (r31 < 0) goto L67;
        this.typeConverters.put(r30, r10.typeConverters.get(r31));
        goto L54
    L67:
        throw new IllegalArgumentException(("A required type converter (" + r30 + ") for " + r28.getCanonicalName() + " is missing in the database configuration.").toString());
    L63:
        r31 = -1;
        goto L64
    L68:
        int r33 = r10.typeConverters.size() - 1;
        if (r33 < 0) goto L77;
    L70:
        int r34 = r33 - 1;
        if (r25.get(r33) == false) goto L76;
        if (r34 < 0) goto L96;
        r33 = r34;
        goto L70
    L96:
        return;
    L76:
        throw new IllegalArgumentException("Unexpected type converter " + r10.typeConverters.get(r33) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
    L77:
        return;
    L45:
        if (r10.name == null) goto L48;
        getInvalidationTracker().startMultiInstanceInvalidation$room_runtime_release(r10.context, r10.name, r10.multiInstanceInvalidationServiceIntent);
        goto L49
    L48:
        throw new IllegalArgumentException("Required value was null.");
    L41:
        r23 = false;
        goto L42
    }

    public void internalInitInvalidationTracker(SupportSQLiteDatabase r5) {
        Intrinsics.checkNotNullParameter(r5, "db");
        getInvalidationTracker().internalInit$room_runtime_release(r5);
    }

    public final boolean isMainThread$room_runtime_release() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isOpen() {
        AutoCloser r5 = this.autoCloser;
        if (r5 == null) goto L6;
        boolean r10 = r5.isActive();
    L5:
        Boolean r11 = Boolean.valueOf(r10);
    L11:
        return Intrinsics.areEqual(r11, Boolean.TRUE);
    L6:
        SupportSQLiteDatabase r12 = this.mDatabase;
        if (r12 == null) goto L9;
        r10 = r12.isOpen();
        goto L5
    L9:
        r11 = null;
        goto L11
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isOpenInternal() {
        SupportSQLiteDatabase r5 = this.mDatabase;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.isOpen() == true) goto L7;
        return false;
    L7:
        return true;
    }

    @JvmOverloads
    public final Cursor query(SupportSQLiteQuery r5) {
        Intrinsics.checkNotNullParameter(r5, "query");
        return query$default(this, r5, null, 2, null);
    }

    public void runInTransaction(Runnable r5) {
        Intrinsics.checkNotNullParameter(r5, "body");
        beginTransaction();
        r5.run();     // Catch: Throwable -> L6
        setTransactionSuccessful();     // Catch: Throwable -> L6
        endTransaction();
        return;
    L6:
        th = move-exception;
        endTransaction();
        throw th;
    }

    public final void setAutoMigrationSpecs(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.autoMigrationSpecs = r5;
    }

    @Deprecated(message = "setTransactionSuccessful() is deprecated", replaceWith = @ReplaceWith(expression = "runInTransaction(Runnable)", imports = {}))
    public void setTransactionSuccessful() {
        getOpenHelper().getWritableDatabase().setTransactionSuccessful();
    }

    public Cursor query(String r5, Object[] r10) {
        Intrinsics.checkNotNullParameter(r5, "query");
        return getOpenHelper().getWritableDatabase().query(new SimpleSQLiteQuery(r5, r10));
    }

    @JvmOverloads
    public Cursor query(SupportSQLiteQuery r5, CancellationSignal r10) {
        Intrinsics.checkNotNullParameter(r5, "query");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (r10 == null) goto L6;
        return getOpenHelper().getWritableDatabase().query(r5, r10);
    L6:
        return getOpenHelper().getWritableDatabase().query(r5);
    }

    public <V> V runInTransaction(Callable<V> r5) {
        Intrinsics.checkNotNullParameter(r5, "body");
        beginTransaction();
        V r10 = r5.call();     // Catch: Throwable -> L6
        setTransactionSuccessful();     // Catch: Throwable -> L6
        endTransaction();
        return r10;
    L6:
        th = move-exception;
        endTransaction();
        throw th;
    }
}
