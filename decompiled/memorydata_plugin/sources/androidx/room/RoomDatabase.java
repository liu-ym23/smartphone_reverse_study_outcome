package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
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
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 p2\u00020\u0001:\u0007nopqrstB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010:\u001a\u00020;H\u0017J\b\u0010<\u001a\u00020;H\u0017J\b\u0010=\u001a\u00020;H\u0017J\b\u0010>\u001a\u00020;H'J\b\u0010?\u001a\u00020;H\u0016J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0010H\u0016J\b\u0010C\u001a\u00020\u0018H$J\u0010\u0010D\u001a\u00020\u00132\u0006\u0010E\u001a\u00020FH$J\b\u0010G\u001a\u00020;H\u0017J*\u0010H\u001a\b\u0012\u0004\u0012\u00020I0#2\u001a\u0010\u0007\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\n0JH\u0017J\r\u0010K\u001a\u00020LH\u0000¢\u0006\u0002\bMJ\u0016\u0010N\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t0OH\u0017J\"\u0010P\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0#0JH\u0015J#\u0010Q\u001a\u0004\u0018\u0001HR\"\u0004\b\u0000\u0010R2\f\u0010S\u001a\b\u0012\u0004\u0012\u0002HR0\tH\u0016¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u00020\u0004H\u0016J\u0010\u0010V\u001a\u00020;2\u0006\u0010W\u001a\u00020FH\u0017J\b\u0010X\u001a\u00020;H\u0002J\b\u0010Y\u001a\u00020;H\u0002J\u0010\u0010Z\u001a\u00020;2\u0006\u0010[\u001a\u00020'H\u0014J\u001c\u0010\\\u001a\u00020]2\u0006\u0010\\\u001a\u00020^2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010`H\u0017J)\u0010\\\u001a\u00020]2\u0006\u0010\\\u001a\u00020\u00102\u0012\u0010a\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010bH\u0016¢\u0006\u0002\u0010cJ\u0010\u0010d\u001a\u00020;2\u0006\u0010e\u001a\u00020fH\u0016J!\u0010d\u001a\u0002Hg\"\u0004\b\u0000\u0010g2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002Hg0hH\u0016¢\u0006\u0002\u0010iJ\b\u0010j\u001a\u00020;H\u0017J+\u0010k\u001a\u0004\u0018\u0001HR\"\u0004\b\u0000\u0010R2\f\u0010l\u001a\b\u0012\u0004\u0012\u0002HR0\t2\u0006\u0010)\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010mR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u0007\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\n0\b8\u0004@\u0004X\u0085\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001f\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\b8G¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u00048VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b\u001e\u0010\u001dR\u0017\u0010 \u001a\u00020\u00048G¢\u0006\f\u0012\u0004\b!\u0010\u0002\u001a\u0004\b \u0010\u001dR \u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#8\u0004@\u0004X\u0085\u000e¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u0002R\u001a\u0010&\u001a\u0004\u0018\u00010'8\u0004@\u0004X\u0085\u000e¢\u0006\b\n\u0000\u0012\u0004\b(\u0010\u0002R\u0014\u0010)\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u00101\u001a\b\u0012\u0004\u0012\u000203028G¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010.R\u001e\u00108\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Landroidx/room/RoomDatabase;", "", "()V", "allowMainThreadQueries", "", "autoCloser", "Landroidx/room/AutoCloser;", "autoMigrationSpecs", "", "Ljava/lang/Class;", "Landroidx/room/migration/AutoMigrationSpec;", "getAutoMigrationSpecs", "()Ljava/util/Map;", "setAutoMigrationSpecs", "(Ljava/util/Map;)V", "backingFieldMap", "", "getBackingFieldMap", "internalOpenHelper", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "internalQueryExecutor", "Ljava/util/concurrent/Executor;", "internalTransactionExecutor", "invalidationTracker", "Landroidx/room/InvalidationTracker;", "getInvalidationTracker", "()Landroidx/room/InvalidationTracker;", "isMainThread", "isMainThread$room_runtime_release", "()Z", "isOpen", "isOpen$annotations", "isOpenInternal", "isOpenInternal$annotations", "mCallbacks", "", "Landroidx/room/RoomDatabase$Callback;", "getMCallbacks$annotations", "mDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getMDatabase$annotations", "openHelper", "getOpenHelper", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "queryExecutor", "getQueryExecutor", "()Ljava/util/concurrent/Executor;", "readWriteLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "suspendingTransactionId", "Ljava/lang/ThreadLocal;", "", "getSuspendingTransactionId", "()Ljava/lang/ThreadLocal;", "transactionExecutor", "getTransactionExecutor", "typeConverters", "writeAheadLoggingEnabled", "assertNotMainThread", "", "assertNotSuspendingTransaction", "beginTransaction", "clearAllTables", IslandSession.REOPEN_VALUE_CLOSE, "compileStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sql", "createInvalidationTracker", "createOpenHelper", "config", "Landroidx/room/DatabaseConfiguration;", "endTransaction", "getAutoMigrations", "Landroidx/room/migration/Migration;", "", "getCloseLock", "Ljava/util/concurrent/locks/Lock;", "getCloseLock$room_runtime_release", "getRequiredAutoMigrationSpecs", "", "getRequiredTypeConverters", "getTypeConverter", ExifInterface.GPS_DIRECTION_TRUE, "klass", "(Ljava/lang/Class;)Ljava/lang/Object;", "inTransaction", CommonConsts.APM_INNER_EVENT_COST_INIT, "configuration", "internalBeginTransaction", "internalEndTransaction", "internalInitInvalidationTracker", "db", ChatMessage.TYPE_QUERY, "Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "signal", "Landroid/os/CancellationSignal;", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "runInTransaction", "body", "Ljava/lang/Runnable;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)Ljava/lang/Object;", "setTransactionSuccessful", "unwrapOpenHelper", "clazz", "(Ljava/lang/Class;Landroidx/sqlite/db/SupportSQLiteOpenHelper;)Ljava/lang/Object;", "Builder", "Callback", "Companion", "JournalMode", "MigrationContainer", "PrepackagedDatabaseCallback", "QueryCallback", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class RoomDatabase {
    public static final Companion Companion = null;
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean allowMainThreadQueries;
    private AutoCloser autoCloser;
    private Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs;
    private final Map<String, Object> backingFieldMap;
    private SupportSQLiteOpenHelper internalOpenHelper;
    private Executor internalQueryExecutor;
    private Executor internalTransactionExecutor;
    private final InvalidationTracker invalidationTracker;
    protected List<? extends Callback> mCallbacks;
    protected volatile SupportSQLiteDatabase mDatabase;
    private final ReentrantReadWriteLock readWriteLock;
    private final ThreadLocal<Integer> suspendingTransactionId;
    private final Map<Class<?>, Object> typeConverters;
    private boolean writeAheadLoggingEnabled;

    @Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0002\b\u000b\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B'\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00104\u001a\u00020\u0014H\u0016J\u0016\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00106\u001a\u00020\u0016H\u0016J'\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u00020:09\"\u00020:H\u0016¢\u0006\u0002\u0010;J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010=\u001a\u00020\u0003H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\r\u0010>\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010?J\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010A\u001a\u00020\tH\u0016J\u001e\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010A\u001a\u00020\t2\u0006\u00106\u001a\u00020*H\u0017J\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010C\u001a\u00020\u0019H\u0016J\u001e\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010C\u001a\u00020\u00192\u0006\u00106\u001a\u00020*H\u0017J\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0017J$\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u00106\u001a\u00020*H\u0017J\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\u0010I\u001a\u00020J\"\u00020%H\u0016J\u000e\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u0018\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J \u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0001\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u0016\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010P\u001a\u00020(H\u0017J\u001e\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010R\u001a\u00020.H\u0016J\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010R\u001a\u00020.H\u0016J\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010R\u001a\u00020.H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Landroidx/room/RoomDatabase$Builder;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/RoomDatabase;", "", "context", "Landroid/content/Context;", "klass", "Ljava/lang/Class;", ActivityLifecycle.NAME, "", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;)V", "allowDestructiveMigrationOnDowngrade", "", "allowMainThreadQueries", "autoCloseTimeUnit", "Ljava/util/concurrent/TimeUnit;", "autoCloseTimeout", "", "autoMigrationSpecs", "", "Landroidx/room/migration/AutoMigrationSpec;", "callbacks", "Landroidx/room/RoomDatabase$Callback;", "copyFromAssetPath", "copyFromFile", "Ljava/io/File;", "copyFromInputStream", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "factory", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "journalMode", "Landroidx/room/RoomDatabase$JournalMode;", "migrationContainer", "Landroidx/room/RoomDatabase$MigrationContainer;", "migrationStartAndEndVersions", "", "", "migrationsNotRequiredFrom", "multiInstanceInvalidationIntent", "Landroid/content/Intent;", "prepackagedDatabaseCallback", "Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;", "queryCallback", "Landroidx/room/RoomDatabase$QueryCallback;", "queryCallbackExecutor", "Ljava/util/concurrent/Executor;", "queryExecutor", "requireMigration", "transactionExecutor", "typeConverters", "addAutoMigrationSpec", "autoMigrationSpec", "addCallback", "callback", "addMigrations", "migrations", "", "Landroidx/room/migration/Migration;", "([Landroidx/room/migration/Migration;)Landroidx/room/RoomDatabase$Builder;", "addTypeConverter", "typeConverter", "build", "()Landroidx/room/RoomDatabase;", "createFromAsset", "databaseFilePath", "createFromFile", "databaseFile", "createFromInputStream", "inputStreamCallable", "enableMultiInstanceInvalidation", "fallbackToDestructiveMigration", "fallbackToDestructiveMigrationFrom", "startVersions", "", "fallbackToDestructiveMigrationOnDowngrade", "openHelperFactory", "setAutoCloseTimeout", "setJournalMode", "setMultiInstanceInvalidationServiceIntent", "invalidationServiceIntent", "setQueryCallback", "executor", "setQueryExecutor", "setTransactionExecutor", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

        public Builder(Context r3, Class<T> r4, String r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "context");
            Intrinsics.checkNotNullParameter(r4, "klass");
            this.context = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
            this.klass = r4;
            this.name = r5;
            this.callbacks = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            this.typeConverters = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            this.autoMigrationSpecs = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            this.journalMode = JournalMode.AUTOMATIC;
            this.requireMigration = true;
            this.autoCloseTimeout = -1;
            this.migrationContainer = new MigrationContainer();
            this.migrationsNotRequiredFrom = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        }

        public Builder<T> addAutoMigrationSpec(AutoMigrationSpec r4) {
            AutoMigrationSpec r5 = (AutoMigrationSpec) ZeusTransformUtils.wrapperContextForParams(r4, AutoMigrationSpec.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "autoMigrationSpec");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).autoMigrationSpecs.add(r5);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder<T> addCallback(Callback r4) {
            Intrinsics.checkNotNullParameter(r4, "callback");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).callbacks.add(r4);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder<T> addMigrations(Migration... r9) {
            Intrinsics.checkNotNullParameter(r9, "migrations");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r2.migrationStartAndEndVersions != null) goto L5;
            r2.migrationStartAndEndVersions = (Set) ZeusTransformUtils.preCheckCast(new HashSet(), Set.class, "com.obric.memorydata.plugin");
        L5:
            int r3 = 0;
            int r4 = r9.length;
        L6:
            if (r3 >= r4) goto L8;
            Migration r5 = r9[r3];
            Set<Integer> r6 = r2.migrationStartAndEndVersions;
            Intrinsics.checkNotNull(r6);
            r6.add(Integer.valueOf(r5.startVersion));
            Set<Integer> r7 = r2.migrationStartAndEndVersions;
            Intrinsics.checkNotNull(r7);
            r7.add(Integer.valueOf(r5.endVersion));
            r3 = r3 + 1;
            goto L6
        L8:
            r2.migrationContainer.addMigrations((Migration[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r9, r9.length), Migration[].class, "com.obric.memorydata.plugin"));
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder<T> addTypeConverter(Object r4) {
            Intrinsics.checkNotNullParameter(r4, "typeConverter");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).typeConverters.add(r4);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder<T> allowMainThreadQueries() {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).allowMainThreadQueries = true;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public T build() {
            Executor r1 = this.queryExecutor;
            if (r1 == null) goto L5;
        L8:
            if (r1 != null) goto L10;
        L12:
            if (r1 != null) goto L14;
            Executor r2 = this.transactionExecutor;
        L7:
            this.queryExecutor = r2;
        L14:
            Set<Integer> r3 = this.migrationStartAndEndVersions;
            boolean r4 = true;
            if (r3 == null) goto L24;
            Intrinsics.checkNotNull(r3);
            Iterator<Integer> r5 = r3.iterator();
        L18:
            if (r5.hasNext() == false) goto L24;
            int r6 = ((Number) ZeusTransformUtils.preCheckCast(r5.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
            if ((!this.migrationsNotRequiredFrom.contains(Integer.valueOf(r6))) == true) goto L18;
            throw new IllegalArgumentException(("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + r6).toString());
        L24:
            SupportSQLiteOpenHelper.Factory r7 = this.factory;
            if (r7 != null) goto L28;
            r7 = (SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.preCheckCast(new FrameworkSQLiteOpenHelperFactory(), SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin");
        L28:
            if (r7 != null) goto L30;
            r7 = null;
        L75:
            if (r7 == null) goto L98;
            if (this.queryCallback == null) goto L87;
            Executor r8 = this.queryCallbackExecutor;
            if (r8 == null) goto L86;
            QueryCallback r9 = this.queryCallback;
            if (r9 == null) goto L84;
            r7 = (SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.preCheckCast(new QueryInterceptorOpenHelperFactory(r7, r8, r9), SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin");
            goto L87
        L84:
            throw new IllegalArgumentException("Required value was null.".toString());
        L86:
            throw new IllegalArgumentException("Required value was null.".toString());
        L87:
            SupportSQLiteOpenHelper.Factory r10 = r7;
            Context r11 = this.context;
            String r12 = this.name;
            MigrationContainer r13 = this.migrationContainer;
            List<Callback> r14 = this.callbacks;
            boolean r15 = this.allowMainThreadQueries;
            JournalMode r16 = this.journalMode.resolve$room_runtime_release(r11);
            Executor r17 = this.queryExecutor;
            if (r17 == null) goto L96;
            Executor r18 = this.transactionExecutor;
            if (r18 == null) goto L94;
            DatabaseConfiguration r19 = new DatabaseConfiguration(r11, r12, r10, r13, r14, r15, r16, r17, r18, this.multiInstanceInvalidationIntent, this.requireMigration, this.allowDestructiveMigrationOnDowngrade, this.migrationsNotRequiredFrom, this.copyFromAssetPath, this.copyFromFile, this.copyFromInputStream, this.prepackagedDatabaseCallback, this.typeConverters, this.autoMigrationSpecs);
            T r0 = (T) ZeusTransformUtils.preCheckCast(Room.getGeneratedImplementation(this.klass, "_Impl"), RoomDatabase.class, "com.obric.memorydata.plugin");
            r0.init(r19);
            return r0;
        L94:
            throw new IllegalArgumentException("Required value was null.".toString());
        L96:
            throw new IllegalArgumentException("Required value was null.".toString());
        L98:
            throw new IllegalArgumentException("Required value was null.".toString());
        L30:
            if (this.autoCloseTimeout > 0) goto L32;
        L44:
            String r20 = this.copyFromAssetPath;
            if (r20 != null) goto L51;
            if (this.copyFromFile != null) goto L51;
            if (this.copyFromInputStream == null) goto L75;
        L51:
            if (this.name == null) goto L73;
            if (r20 != null) goto L55;
            int r21 = 0;
        L57:
            if (this.copyFromFile != null) goto L59;
            int r22 = 0;
        L61:
            if (this.copyFromInputStream != null) goto L63;
            int r23 = 0;
        L65:
            if (((r21 + r22) + r23) == 1) goto L68;
            r4 = false;
        L68:
            if (r4 == false) goto L71;
            r7 = (SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.preCheckCast(new SQLiteCopyOpenHelperFactory(this.copyFromAssetPath, this.copyFromFile, this.copyFromInputStream, r7), SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin");
            goto L75
        L71:
            throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.".toString());
        L63:
            r23 = 1;
            goto L65
        L59:
            r22 = 1;
            goto L61
        L55:
            r21 = 1;
            goto L57
        L73:
            throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.".toString());
        L32:
            if (this.name == null) goto L43;
            long r24 = this.autoCloseTimeout;
            TimeUnit r25 = this.autoCloseTimeUnit;
            if (r25 == null) goto L41;
            Executor r26 = this.queryExecutor;
            if (r26 == null) goto L39;
            r7 = (SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.preCheckCast(new AutoClosingRoomOpenHelperFactory(r7, new AutoCloser(r24, r25, r26)), SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin");
            goto L44
        L39:
            throw new IllegalArgumentException("Required value was null.".toString());
        L41:
            throw new IllegalArgumentException("Required value was null.".toString());
        L43:
            throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.".toString());
        L10:
            if (this.transactionExecutor != null) goto L12;
            this.transactionExecutor = r1;
            goto L14
        L5:
            if (this.transactionExecutor != null) goto L8;
            r2 = ArchTaskExecutor.getIOThreadExecutor();
            this.transactionExecutor = r2;
            goto L7
        }

        public Builder<T> createFromAsset(String r4) {
            Intrinsics.checkNotNullParameter(r4, "databaseFilePath");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).copyFromAssetPath = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder<T> createFromAsset(String r4, PrepackagedDatabaseCallback r5) {
            Intrinsics.checkNotNullParameter(r4, "databaseFilePath");
            Intrinsics.checkNotNullParameter(r5, "callback");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.prepackagedDatabaseCallback = r5;
            r2.copyFromAssetPath = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder<T> createFromFile(File r4) {
            Intrinsics.checkNotNullParameter(r4, "databaseFile");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).copyFromFile = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder<T> createFromFile(File r4, PrepackagedDatabaseCallback r5) {
            Intrinsics.checkNotNullParameter(r4, "databaseFile");
            Intrinsics.checkNotNullParameter(r5, "callback");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.prepackagedDatabaseCallback = r5;
            r2.copyFromFile = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder<T> createFromInputStream(Callable<InputStream> r4) {
            Callable<InputStream> r5 = (Callable) ZeusTransformUtils.wrapperContextForParams(r4, Callable.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "inputStreamCallable");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).copyFromInputStream = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder<T> createFromInputStream(Callable<InputStream> r4, PrepackagedDatabaseCallback r5) {
            Callable<InputStream> r6 = (Callable) ZeusTransformUtils.wrapperContextForParams(r4, Callable.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "inputStreamCallable");
            Intrinsics.checkNotNullParameter(r5, "callback");
            Builder r1 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r1.prepackagedDatabaseCallback = r5;
            r1.copyFromInputStream = r6;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder<T> enableMultiInstanceInvalidation() {
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r2.name == null) goto L5;
            Intent r3 = new Intent(r2.context, MultiInstanceInvalidationService.class);
        L6:
            r2.multiInstanceInvalidationIntent = r3;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L5:
            r3 = (Intent) ZeusTransformUtils.preCheckCast(null, Intent.class, "com.obric.memorydata.plugin");
            goto L6
        }

        public Builder<T> fallbackToDestructiveMigration() {
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.requireMigration = false;
            r2.allowDestructiveMigrationOnDowngrade = true;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder<T> fallbackToDestructiveMigrationFrom(int... r8) {
            Intrinsics.checkNotNullParameter(r8, "startVersions");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            int r3 = r8.length;
            int r4 = 0;
        L3:
            if (r4 >= r3) goto L6;
            int r5 = r8[r4];
            r2.migrationsNotRequiredFrom.add(Integer.valueOf(r5));
            r4 = r4 + 1;
            goto L3
        L6:
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.requireMigration = true;
            r2.allowDestructiveMigrationOnDowngrade = true;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder<T> openHelperFactory(SupportSQLiteOpenHelper.Factory r4) {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).factory = (SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin");
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        @ExperimentalRoomApi
        public Builder<T> setAutoCloseTimeout(long r6, TimeUnit r8) {
            Intrinsics.checkNotNullParameter(r8, "autoCloseTimeUnit");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r6 < 0) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == false) goto L10;
            r2.autoCloseTimeout = r6;
            r2.autoCloseTimeUnit = r8;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L10:
            throw new IllegalArgumentException("autoCloseTimeout must be >= 0".toString());
        L5:
            r3 = false;
            goto L6
        }

        public Builder<T> setJournalMode(JournalMode r4) {
            Intrinsics.checkNotNullParameter(r4, "journalMode");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).journalMode = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        @ExperimentalRoomApi
        public Builder<T> setMultiInstanceInvalidationServiceIntent(Intent r5) {
            Intrinsics.checkNotNullParameter(r5, "invalidationServiceIntent");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r2.name != null) goto L6;
            r5 = null;
        L6:
            r2.multiInstanceInvalidationIntent = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder<T> setQueryCallback(QueryCallback r4, Executor r5) {
            QueryCallback r6 = (QueryCallback) ZeusTransformUtils.wrapperContextForParams(r4, QueryCallback.class, "com.obric.memorydata.plugin");
            Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "queryCallback");
            Intrinsics.checkNotNullParameter(r7, "executor");
            Builder r1 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r1.queryCallback = r6;
            r1.queryCallbackExecutor = r7;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder<T> setQueryExecutor(Executor r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "executor");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).queryExecutor = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder<T> setTransactionExecutor(Executor r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "executor");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).transactionExecutor = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Landroidx/room/RoomDatabase$Callback;", "", "()V", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "onDestructiveMigration", "onOpen", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class Callback {
        public Callback() {
        }

        public void onCreate(SupportSQLiteDatabase r2) {
            Intrinsics.checkNotNullParameter((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"), "db");
        }

        public void onDestructiveMigration(SupportSQLiteDatabase r2) {
            Intrinsics.checkNotNullParameter((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"), "db");
        }

        public void onOpen(SupportSQLiteDatabase r2) {
            Intrinsics.checkNotNullParameter((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"), "db");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/RoomDatabase$Companion;", "", "()V", "MAX_BIND_PARAMETER_CNT", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
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

        private JournalMode(String r1, int r2) {
            super(r1, r2);
        }

        private final boolean isLowRamDevice(ActivityManager r2) {
            if (Build.VERSION.SDK_INT >= 19) goto L7;
            return false;
        L7:
            return SupportSQLiteCompat.Api19Impl.isLowRamDevice(r2);
        }

        public static JournalMode valueOf(String r2) {
            return (JournalMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(JournalMode.class, r2), JournalMode.class, "com.obric.memorydata.plugin");
        }

        public static JournalMode[] values() {
            return (JournalMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), JournalMode[].class, "com.obric.memorydata.plugin");
        }

        public final JournalMode resolve$room_runtime_release(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "context");
            if (this == AUTOMATIC) goto L6;
            return this;
        L6:
            if (Build.VERSION.SDK_INT < 16) goto L17;
            Object r6 = r5.getSystemService("activity");
            if (ZeusTransformUtils.instanceOf(r6, ActivityManager.class) == false) goto L10;
            ActivityManager r7 = (ActivityManager) ZeusTransformUtils.preCheckCast(r6, ActivityManager.class, "com.obric.memorydata.plugin");
        L11:
            if (r7 == null) goto L17;
            if (isLowRamDevice(r7) == true) goto L17;
            return WRITE_AHEAD_LOGGING;
        L10:
            r7 = null;
        L17:
            return TRUNCATE;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002J!\u0010\u000b\u001a\u00020\t2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\f\"\u00020\u0007H\u0016¢\u0006\u0002\u0010\rJ\u0016\u0010\u000b\u001a\u00020\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J \u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J6\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J \u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u001b0\u001bH\u0016R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/room/RoomDatabase$MigrationContainer;", "", "()V", "migrations", "", "", "Ljava/util/TreeMap;", "Landroidx/room/migration/Migration;", "addMigration", "", "migration", "addMigrations", "", "([Landroidx/room/migration/Migration;)V", "", "contains", "", "startVersion", "endVersion", "findMigrationPath", CommonConsts.APM_INNER_EVENT_COST_START, "end", "findUpMigrationPath", "result", "", "upgrade", "getMigrations", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class MigrationContainer {
        private final Map<Integer, TreeMap<Integer, Migration>> migrations;

        public MigrationContainer() {
            this.migrations = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        }

        private final void addMigration(Migration r5) {
            int r0 = r5.startVersion;
            int r1 = r5.endVersion;
            Map<Integer, TreeMap<Integer, Migration>> r4 = this.migrations;
            Integer r2 = Integer.valueOf(r0);
            TreeMap<Integer, Migration> r3 = r4.get(r2);
            if (r3 != null) goto L5;
            r3 = new TreeMap();
            r4.put(r2, r3);
        L5:
            TreeMap r6 = (TreeMap) ZeusTransformUtils.preCheckCast(r3, TreeMap.class, "com.obric.memorydata.plugin");
            if (((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).containsKey(Integer.valueOf(r1)) == false) goto L8;
            Log.w(Room.LOG_TAG, "Overriding migration " + r6.get(Integer.valueOf(r1)) + " with " + r5);
        L8:
            ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).put(Integer.valueOf(r1), r5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final List<Migration> findUpMigrationPath(List<Migration> r10, boolean r11, int r12, int r13) {
            List<Migration> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        L3:
            boolean r0 = true;
            if (r11 == false) goto L7;
            if (r12 < r13) goto L8;
        L9:
            boolean r3 = false;
        L10:
            if (r3 == false) goto L36;
            TreeMap r4 = (TreeMap) ZeusTransformUtils.preCheckCast(this.migrations.get(Integer.valueOf(r12)), TreeMap.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L13;
            if (r11 == false) goto L16;
            Set r5 = (Set) ZeusTransformUtils.preCheckCast(r4.descendingKeySet(), Set.class, "com.obric.memorydata.plugin");
        L17:
            Iterator r6 = r5.iterator();
        L19:
            if (r6.hasNext() == false) goto L33;
            Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r6.next(), Integer.class, "com.obric.memorydata.plugin");
            if (r11 == false) goto L26;
            int r8 = r12 + 1;
            Intrinsics.checkNotNullExpressionValue(r7, "targetVersion");
            int r9 = r7.intValue();
            if (r8 > r9) goto L30;
            if (r9 > r13) goto L30;
        L29:
            boolean r15 = true;
        L31:
            if (r15 == false) goto L19;
            Object r16 = r4.get(r7);
            Intrinsics.checkNotNull(r16);
            r14.add(r16);
            r12 = r7.intValue();
        L34:
            if (r0 == true) goto L3;
            return null;
        L30:
            r15 = false;
            goto L31
        L26:
            Intrinsics.checkNotNullExpressionValue(r7, "targetVersion");
            int r17 = r7.intValue();
            if (r13 > r17) goto L30;
            if (r17 >= r12) goto L30;
        L33:
            r0 = false;
            goto L34
        L16:
            r5 = r4.keySet();
            goto L17
        L13:
            return null;
        L36:
            return r14;
        L8:
            r3 = true;
            goto L10
        L7:
            if (r12 <= r13) goto L9;
            goto L8
        }

        public void addMigrations(List<? extends Migration> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "migrations");
            Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            addMigration((Migration) ZeusTransformUtils.preCheckCast(r6.next(), Migration.class, "com.obric.memorydata.plugin"));
            goto L4
        }

        public void addMigrations(Migration... r4) {
            Intrinsics.checkNotNullParameter(r4, "migrations");
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            addMigration(r4[r1]);
            r1 = r1 + 1;
            goto L3
        }

        public final boolean contains(int r2, int r3) {
            Map<Integer, Map<Integer, Migration>> r1 = getMigrations();
            if (r1.containsKey(Integer.valueOf(r2)) == false) goto L9;
            Map r4 = (Map) ZeusTransformUtils.preCheckCast(r1.get(Integer.valueOf(r2)), Map.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L8;
            r4 = MapsKt.emptyMap();
        L8:
            return r4.containsKey(Integer.valueOf(r3));
        L9:
            return false;
        }

        public List<Migration> findMigrationPath(int r5, int r6) {
            if (r5 == r6) goto L4;
            if (r6 <= r5) goto L7;
            boolean r0 = true;
        L9:
            return findUpMigrationPath((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"), r0, r5, r6);
        L7:
            r0 = false;
            goto L9
        L4:
            return CollectionsKt.emptyList();
        }

        public Map<Integer, Map<Integer, Migration>> getMigrations() {
            return this.migrations;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;", "", "()V", "onOpenPrepackagedDatabase", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class PrepackagedDatabaseCallback {
        public PrepackagedDatabaseCallback() {
        }

        public void onOpenPrepackagedDatabase(SupportSQLiteDatabase r2) {
            Intrinsics.checkNotNullParameter((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"), "db");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/room/RoomDatabase$QueryCallback;", "", "onQuery", "", "sqlQuery", "", "bindArgs", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface QueryCallback {
        void onQuery(String r1, List<? extends Object> r2);
    }

    static {
        Companion = new Companion(null);
    }

    public RoomDatabase() {
        this.invalidationTracker = createInvalidationTracker();
        this.autoMigrationSpecs = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.readWriteLock = new ReentrantReadWriteLock();
        this.suspendingTransactionId = new ThreadLocal();
        Map<String, Object> r0 = Collections.synchronizedMap((Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r0, "synchronizedMap(mutableMapOf())");
        this.backingFieldMap = r0;
        this.typeConverters = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$internalBeginTransaction(RoomDatabase r0) {
        r0.internalBeginTransaction();
    }

    public static final /* synthetic */ void access$internalEndTransaction(RoomDatabase r0) {
        r0.internalEndTransaction();
    }

    @Deprecated(message = "Will be hidden in a future release.")
    public static /* synthetic */ void getMCallbacks$annotations() {
    }

    @Deprecated(message = "Will be hidden in the next release.")
    public static /* synthetic */ void getMDatabase$annotations() {
    }

    private final void internalBeginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase r0 = getOpenHelper().getWritableDatabase();
        getInvalidationTracker().syncTriggers$room_runtime_release(r0);
        if (Build.VERSION.SDK_INT >= 16) goto L5;
    L7:
        r0.beginTransaction();
        return;
    L5:
        if (r0.isWriteAheadLoggingEnabled() == false) goto L7;
        r0.beginTransactionNonExclusive();
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

    public static /* synthetic */ Cursor query$default(RoomDatabase r2, SupportSQLiteQuery r3, CancellationSignal r4, int r5, Object r6) {
        SupportSQLiteQuery r7 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L8;
        r4 = null;
    L8:
        return r2.query(r7, r4);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
    }

    private final <T> T unwrapOpenHelper(Class<T> r3, SupportSQLiteOpenHelper r4) {
        SupportSQLiteOpenHelper r5 = (SupportSQLiteOpenHelper) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteOpenHelper.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, r5) == false) goto L7;
        return (T) ZeusTransformUtils.preCheckCast(r5, Object.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r5, DelegatingOpenHelper.class) == true) goto L11;
        return null;
    L11:
        return (T) unwrapOpenHelper(r3, ((DelegatingOpenHelper) ZeusTransformUtils.preCheckCast(r5, DelegatingOpenHelper.class, "com.obric.memorydata.plugin")).getDelegate());
    }

    public void assertNotMainThread() {
        if (this.allowMainThreadQueries == false) goto L6;
        return;
    L6:
        if ((!isMainThread$room_runtime_release()) == false) goto L9;
        return;
    L9:
        throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.".toString());
    }

    public void assertNotSuspendingTransaction() {
        if (inTransaction() == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return;
    L12:
        throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.".toString());
    L5:
        if (this.suspendingTransactionId.get() == null) goto L8;
        r1 = false;
        goto L9
    }

    @Deprecated(message = "beginTransaction() is deprecated", replaceWith = @ReplaceWith(expression = "runInTransaction(Runnable)", imports = {}))
    public void beginTransaction() {
        assertNotMainThread();
        AutoCloser r0 = this.autoCloser;
        if (r0 != null) goto L5;
        internalBeginTransaction();
        return;
    L5:
        r0.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Function1.class, "com.obric.memorydata.plugin"));
    }

    public abstract void clearAllTables();

    public void close() {
        if (isOpen() == false) goto L10;
        ReentrantReadWriteLock.WriteLock r0 = this.readWriteLock.writeLock();
        Intrinsics.checkNotNullExpressionValue(r0, "readWriteLock.writeLock()");
        Lock r1 = (Lock) ZeusTransformUtils.preCheckCast(r0, Lock.class, "com.obric.memorydata.plugin");
        r1.lock();
        getInvalidationTracker().stopMultiInstanceInvalidation$room_runtime_release();     // Catch: Throwable -> L7
        getOpenHelper().close();     // Catch: Throwable -> L7
        r1.unlock();
        return;
    L7:
        th = move-exception;
        r1.unlock();
        throw th;
    }

    public SupportSQLiteStatement compileStatement(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sql");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().compileStatement(r2);
    }

    public abstract InvalidationTracker createInvalidationTracker();

    public abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r1);

    @Deprecated(message = "endTransaction() is deprecated", replaceWith = @ReplaceWith(expression = "runInTransaction(Runnable)", imports = {}))
    public void endTransaction() {
        AutoCloser r0 = this.autoCloser;
        if (r0 != null) goto L5;
        internalEndTransaction();
        return;
    L5:
        r0.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(new C09751(this), Function1.class, "com.obric.memorydata.plugin"));
    }

    public final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> getAutoMigrationSpecs() {
        return this.autoMigrationSpecs;
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r2) {
        Intrinsics.checkNotNullParameter((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), "autoMigrationSpecs");
        return CollectionsKt.emptyList();
    }

    public final Map<String, Object> getBackingFieldMap() {
        return this.backingFieldMap;
    }

    public final Lock getCloseLock$room_runtime_release() {
        ReentrantReadWriteLock.ReadLock r2 = this.readWriteLock.readLock();
        Intrinsics.checkNotNullExpressionValue(r2, "readWriteLock.readLock()");
        return (Lock) ZeusTransformUtils.preCheckCast(r2, Lock.class, "com.obric.memorydata.plugin");
    }

    public InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    public SupportSQLiteOpenHelper getOpenHelper() {
        SupportSQLiteOpenHelper r0 = this.internalOpenHelper;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("internalOpenHelper");
        return null;
    L6:
        return r0;
    }

    public Executor getQueryExecutor() {
        Executor r0 = this.internalQueryExecutor;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("internalQueryExecutor");
        return null;
    L6:
        return r0;
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return SetsKt.emptySet();
    }

    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return MapsKt.emptyMap();
    }

    public final ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.suspendingTransactionId;
    }

    public Executor getTransactionExecutor() {
        Executor r0 = this.internalTransactionExecutor;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("internalTransactionExecutor");
        return null;
    L6:
        return r0;
    }

    public <T> T getTypeConverter(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "klass");
        return (T) this.typeConverters.get(r2);
    }

    public boolean inTransaction() {
        return getOpenHelper().getWritableDatabase().inTransaction();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void init(DatabaseConfiguration r13) {
        Intrinsics.checkNotNullParameter(r13, "configuration");
        this.internalOpenHelper = createOpenHelper(r13);
        Set<Class<? extends AutoMigrationSpec>> r0 = getRequiredAutoMigrationSpecs();
        BitSet r1 = new BitSet();
        Iterator<Class<? extends AutoMigrationSpec>> r2 = r0.iterator();
    L3:
        boolean r3 = true;
        int r6 = -1;
        if (r2.hasNext() == false) goto L20;
        Class<? extends AutoMigrationSpec> r4 = (Class) ZeusTransformUtils.preCheckCast(r2.next(), Class.class, "com.obric.memorydata.plugin");
        int r5 = r13.autoMigrationSpecs.size() - 1;
        if (r5 < 0) goto L13;
    L7:
        int r7 = r5 - 1;
        if (r4.isAssignableFrom(r13.autoMigrationSpecs.get(r5).getClass()) == true) goto L9;
        if (r7 < 0) goto L13;
        r5 = r7;
        goto L7
    L9:
        r1.set(r5);
        r6 = r5;
    L13:
        if (r6 >= 0) goto L16;
        r3 = false;
    L16:
        if (r3 == false) goto L19;
        this.autoMigrationSpecs.put(r4, r13.autoMigrationSpecs.get(r6));
        goto L3
    L19:
        throw new IllegalArgumentException(("A required auto migration spec (" + r4.getCanonicalName() + ") is missing in the database configuration.").toString());
    L20:
        int r8 = r13.autoMigrationSpecs.size() - 1;
        if (r8 < 0) goto L29;
    L22:
        int r9 = r8 - 1;
        if (r1.get(r8) == false) goto L28;
        if (r9 < 0) goto L29;
        r8 = r9;
        goto L22
    L28:
        throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.".toString());
    L29:
        Iterator<Migration> r10 = getAutoMigrations(this.autoMigrationSpecs).iterator();
    L31:
        if (r10.hasNext() == false) goto L35;
        Migration r11 = (Migration) ZeusTransformUtils.preCheckCast(r10.next(), Migration.class, "com.obric.memorydata.plugin");
        if (r13.migrationContainer.contains(r11.startVersion, r11.endVersion) == true) goto L31;
        r13.migrationContainer.addMigrations(new Migration[]{r11});
        goto L31
    L35:
        SQLiteCopyOpenHelper r12 = (SQLiteCopyOpenHelper) ZeusTransformUtils.preCheckCast(unwrapOpenHelper(SQLiteCopyOpenHelper.class, getOpenHelper()), SQLiteCopyOpenHelper.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L38;
        r12.setDatabaseConfiguration(r13);
    L38:
        AutoClosingRoomOpenHelper r14 = (AutoClosingRoomOpenHelper) ZeusTransformUtils.preCheckCast(unwrapOpenHelper(AutoClosingRoomOpenHelper.class, getOpenHelper()), AutoClosingRoomOpenHelper.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L42;
        this.autoCloser = r14.autoCloser;
        getInvalidationTracker().setAutoCloser$room_runtime_release(r14.autoCloser);
    L42:
        if (Build.VERSION.SDK_INT >= 16) goto L44;
        boolean r15 = false;
    L49:
        this.mCallbacks = r13.callbacks;
        this.internalQueryExecutor = r13.queryExecutor;
        this.internalTransactionExecutor = (Executor) ZeusTransformUtils.preCheckCast(new TransactionExecutor(r13.transactionExecutor), Executor.class, "com.obric.memorydata.plugin");
        this.allowMainThreadQueries = r13.allowMainThreadQueries;
        this.writeAheadLoggingEnabled = r15;
        if (r13.multiInstanceInvalidationServiceIntent != null) goto L52;
    L56:
        Map<Class<?>, List<Class<?>>> r16 = getRequiredTypeConverters();
        BitSet r17 = new BitSet();
        Iterator<Map.Entry<Class<?>, List<Class<?>>>> r18 = r16.entrySet().iterator();
    L58:
        if (r18.hasNext() == false) goto L78;
        Map.Entry r19 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Class r20 = (Class) ZeusTransformUtils.preCheckCast(r19.getKey(), Class.class, "com.obric.memorydata.plugin");
        Iterator r21 = ((List) ZeusTransformUtils.preCheckCast(r19.getValue(), List.class, "com.obric.memorydata.plugin")).iterator();
    L61:
        if (r21.hasNext() == false) goto L58;
        Class<?> r22 = (Class) ZeusTransformUtils.preCheckCast(r21.next(), Class.class, "com.obric.memorydata.plugin");
        int r23 = r13.typeConverters.size() - 1;
        if (r23 < 0) goto L70;
    L64:
        int r110 = r23 - 1;
        if (r22.isAssignableFrom(r13.typeConverters.get(r23).getClass()) == true) goto L66;
        if (r110 < 0) goto L70;
        r23 = r110;
        goto L64
    L66:
        r17.set(r23);
    L71:
        if (r23 < 0) goto L73;
        boolean r111 = true;
    L74:
        if (r111 == false) goto L77;
        this.typeConverters.put(r22, r13.typeConverters.get(r23));
        goto L61
    L77:
        throw new IllegalArgumentException(("A required type converter (" + r22 + ") for " + r20.getCanonicalName() + " is missing in the database configuration.").toString());
    L73:
        r111 = false;
    L70:
        r23 = -1;
        goto L71
    L78:
        int r112 = r13.typeConverters.size() - 1;
        if (r112 < 0) goto L87;
    L80:
        int r24 = r112 - 1;
        if (r17.get(r112) == false) goto L86;
        if (r24 < 0) goto L106;
        r112 = r24;
        goto L80
    L106:
        return;
    L86:
        throw new IllegalArgumentException("Unexpected type converter " + r13.typeConverters.get(r112) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
    L87:
        return;
    L52:
        if (r13.name == null) goto L55;
        getInvalidationTracker().startMultiInstanceInvalidation$room_runtime_release(r13.context, r13.name, r13.multiInstanceInvalidationServiceIntent);
        goto L56
    L55:
        throw new IllegalArgumentException("Required value was null.".toString());
    L44:
        if (r13.journalMode != JournalMode.WRITE_AHEAD_LOGGING) goto L46;
        r15 = true;
    L47:
        getOpenHelper().setWriteAheadLoggingEnabled(r15);
        goto L49
    L46:
        r15 = false;
        goto L47
    }

    public void internalInitInvalidationTracker(SupportSQLiteDatabase r3) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "db");
        getInvalidationTracker().internalInit$room_runtime_release(r4);
    }

    public final boolean isMainThread$room_runtime_release() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isOpen() {
        AutoCloser r0 = this.autoCloser;
        if (r0 == null) goto L6;
        boolean r1 = r0.isActive();
    L5:
        Boolean r2 = Boolean.valueOf(r1);
    L11:
        return Intrinsics.areEqual(r2, true);
    L6:
        SupportSQLiteDatabase r3 = this.mDatabase;
        if (r3 == null) goto L9;
        r1 = r3.isOpen();
        goto L5
    L9:
        r2 = null;
        goto L11
    }

    public final boolean isOpenInternal() {
        SupportSQLiteDatabase r2 = this.mDatabase;
        if (r2 == null) goto L8;
        if (r2.isOpen() != true) goto L8;
        return true;
    L8:
        return false;
    }

    public final Cursor query(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, ChatMessage.TYPE_QUERY);
        return query$default(this, r4, null, 2, null);
    }

    public Cursor query(SupportSQLiteQuery r3, CancellationSignal r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, ChatMessage.TYPE_QUERY);
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (r4 == null) goto L8;
        if (Build.VERSION.SDK_INT < 16) goto L8;
        return getOpenHelper().getWritableDatabase().query(r5, r4);
    L8:
        return getOpenHelper().getWritableDatabase().query(r5);
    }

    public Cursor query(String r2, Object[] r3) {
        Intrinsics.checkNotNullParameter(r2, ChatMessage.TYPE_QUERY);
        return getOpenHelper().getWritableDatabase().query((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery(r2, r3), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
    }

    public <V> V runInTransaction(Callable<V> r3) {
        Callable r4 = (Callable) ZeusTransformUtils.wrapperContextForParams(r3, Callable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "body");
        beginTransaction();
        V r5 = (V) r4.call();
        setTransactionSuccessful();     // Catch: Throwable -> L6
        endTransaction();
        return r5;
    L6:
        th = move-exception;
        endTransaction();
        throw th;
    }

    public void runInTransaction(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "body");
        beginTransaction();
        r4.run();     // Catch: Throwable -> L6
        setTransactionSuccessful();     // Catch: Throwable -> L6
        endTransaction();
        return;
    L6:
        th = move-exception;
        endTransaction();
        throw th;
    }

    public final void setAutoMigrationSpecs(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r3) {
        Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.autoMigrationSpecs = r4;
    }

    @Deprecated(message = "setTransactionSuccessful() is deprecated", replaceWith = @ReplaceWith(expression = "runInTransaction(Runnable)", imports = {}))
    public void setTransactionSuccessful() {
        getOpenHelper().getWritableDatabase().setTransactionSuccessful();
    }
}
