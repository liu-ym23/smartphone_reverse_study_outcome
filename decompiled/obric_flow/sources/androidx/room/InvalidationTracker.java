package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 e2\u00020\u0001:\u0005efghiB#\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0002\u0010\u0007BV\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\t\u0012\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\f0\t\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0002\u0010\rJ\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\"H\u0017J\u0010\u0010;\u001a\u0002092\u0006\u0010:\u001a\u00020\"H\u0017J7\u0010<\u001a\b\u0012\u0004\u0012\u0002H>0=\"\u0004\b\u0000\u0010>2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\f\u0010?\u001a\b\u0012\u0004\u0012\u0002H>0@H\u0017¢\u0006\u0002\u0010AJ?\u0010<\u001a\b\u0012\u0004\u0012\u0002H>0=\"\u0004\b\u0000\u0010>2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u0006\u0010B\u001a\u00020\u00192\f\u0010?\u001a\b\u0012\u0004\u0012\u0002H>0@H\u0017¢\u0006\u0002\u0010CJ\r\u0010D\u001a\u00020\u0019H\u0000¢\u0006\u0002\bEJ\u0015\u0010F\u001a\u0002092\u0006\u0010\u0002\u001a\u00020GH\u0000¢\u0006\u0002\bHJ!\u0010I\u001a\u0002092\u0012\u0010J\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u0007¢\u0006\u0002\u0010KJ\b\u0010L\u001a\u000209H\u0002J\b\u0010M\u001a\u000209H\u0016J\b\u0010N\u001a\u000209H\u0017J\u0010\u0010O\u001a\u0002092\u0006\u0010:\u001a\u00020\"H\u0017J%\u0010P\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u000e\u0010Q\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0002\u0010RJ\u0015\u0010S\u001a\u0002092\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\bTJ%\u0010U\u001a\u0002092\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020ZH\u0000¢\u0006\u0002\b[J\u0018\u0010\\\u001a\u0002092\u0006\u0010]\u001a\u00020G2\u0006\u0010^\u001a\u000200H\u0002J\r\u0010_\u001a\u000209H\u0000¢\u0006\u0002\b`J\u0018\u0010a\u001a\u0002092\u0006\u0010]\u001a\u00020G2\u0006\u0010^\u001a\u000200H\u0002J\r\u0010b\u001a\u000209H\u0000¢\u0006\u0002\bcJ\u0015\u0010b\u001a\u0002092\u0006\u0010\u0002\u001a\u00020GH\u0000¢\u0006\u0002\bcJ%\u0010d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0002\u0010RR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!8\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020'8GX\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020+8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b,\u0010-R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002000\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001e\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u000e\u00107\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Landroidx/room/InvalidationTracker;", "", "database", "Landroidx/room/RoomDatabase;", "tableNames", "", "", "(Landroidx/room/RoomDatabase;[Ljava/lang/String;)V", "shadowTablesMap", "", "viewTables", "", "Lkotlin/jvm/JvmSuppressWildcards;", "(Landroidx/room/RoomDatabase;Ljava/util/Map;Ljava/util/Map;[Ljava/lang/String;)V", "autoCloser", "Landroidx/room/AutoCloser;", "cleanupStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "getCleanupStatement$room_runtime_release", "()Landroidx/sqlite/db/SupportSQLiteStatement;", "setCleanupStatement$room_runtime_release", "(Landroidx/sqlite/db/SupportSQLiteStatement;)V", "getDatabase$room_runtime_release", "()Landroidx/room/RoomDatabase;", "initialized", "", "invalidationLiveDataContainer", "Landroidx/room/InvalidationLiveDataContainer;", "multiInstanceInvalidationClient", "Landroidx/room/MultiInstanceInvalidationClient;", "observedTableTracker", "Landroidx/room/InvalidationTracker$ObservedTableTracker;", "observerMap", "Landroidx/arch/core/internal/SafeIterableMap;", "Landroidx/room/InvalidationTracker$Observer;", "Landroidx/room/InvalidationTracker$ObserverWrapper;", "getObserverMap$room_runtime_release", "()Landroidx/arch/core/internal/SafeIterableMap;", "pendingRefresh", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getPendingRefresh", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "refreshRunnable", "Ljava/lang/Runnable;", "getRefreshRunnable$annotations", "()V", "syncTriggersLock", "tableIdLookup", "", "getTableIdLookup$room_runtime_release", "()Ljava/util/Map;", "tablesNames", "getTablesNames$room_runtime_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "trackerLock", "addObserver", "", "observer", "addWeakObserver", "createLiveData", "Landroidx/lifecycle/LiveData;", ExifInterface.GPS_DIRECTION_TRUE, "computeFunction", "Ljava/util/concurrent/Callable;", "([Ljava/lang/String;Ljava/util/concurrent/Callable;)Landroidx/lifecycle/LiveData;", "inTransaction", "([Ljava/lang/String;ZLjava/util/concurrent/Callable;)Landroidx/lifecycle/LiveData;", "ensureInitialization", "ensureInitialization$room_runtime_release", "internalInit", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "internalInit$room_runtime_release", "notifyObserversByTableNames", "tables", "([Ljava/lang/String;)V", "onAutoCloseCallback", "refreshVersionsAsync", "refreshVersionsSync", "removeObserver", "resolveViews", "names", "([Ljava/lang/String;)[Ljava/lang/String;", "setAutoCloser", "setAutoCloser$room_runtime_release", "startMultiInstanceInvalidation", "context", "Landroid/content/Context;", "name", "serviceIntent", "Landroid/content/Intent;", "startMultiInstanceInvalidation$room_runtime_release", "startTrackingTable", "db", "tableId", "stopMultiInstanceInvalidation", "stopMultiInstanceInvalidation$room_runtime_release", "stopTrackingTable", "syncTriggers", "syncTriggers$room_runtime_release", "validateAndResolveTableNames", "Companion", "ObservedTableTracker", "Observer", "ObserverWrapper", "WeakObserver", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class InvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    public static final Companion Companion = null;
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    public static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1";
    public static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String[] TRIGGERS = null;
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    private AutoCloser autoCloser;
    private volatile SupportSQLiteStatement cleanupStatement;
    private final RoomDatabase database;
    private volatile boolean initialized;
    private final InvalidationLiveDataContainer invalidationLiveDataContainer;
    private MultiInstanceInvalidationClient multiInstanceInvalidationClient;
    private final ObservedTableTracker observedTableTracker;

    @GuardedBy("observerMap")
    private final SafeIterableMap<Observer, ObserverWrapper> observerMap;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    private final AtomicBoolean pendingRefresh;

    @JvmField
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final Runnable refreshRunnable;
    private final Map<String, String> shadowTablesMap;
    private final Object syncTriggersLock;
    private final Map<String, Integer> tableIdLookup;
    private final String[] tablesNames;
    private final Object trackerLock;
    private final Map<String, Set<String>> viewTables;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\u001d\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/room/InvalidationTracker$Companion;", "", "()V", "CREATE_TRACKING_TABLE_SQL", "", "INVALIDATED_COLUMN_NAME", "RESET_UPDATED_TABLES_SQL", "getRESET_UPDATED_TABLES_SQL$room_runtime_release$annotations", "SELECT_UPDATED_TABLES_SQL", "getSELECT_UPDATED_TABLES_SQL$room_runtime_release$annotations", "TABLE_ID_COLUMN_NAME", "TRIGGERS", "", "[Ljava/lang/String;", "UPDATE_TABLE_NAME", "beginTransactionInternal", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "beginTransactionInternal$room_runtime_release", "getTriggerName", "tableName", "triggerType", "getTriggerName$room_runtime_release", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getRESET_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getSELECT_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        public final void beginTransactionInternal$room_runtime_release(SupportSQLiteDatabase r5) {
            Intrinsics.checkNotNullParameter(r5, "database");
            if (r5.isWriteAheadLoggingEnabled() == false) goto L5;
            r5.beginTransactionNonExclusive();
            return;
        L5:
            r5.beginTransaction();
        }

        public final String getTriggerName$room_runtime_release(String r5, String r10) {
            StringBuilder r11 = androidx.constraintlayout.motion.widget.a.D(r5, "tableName", r10, "triggerType", "`room_table_modification_trigger_");
            r11.append(r5);
            r11.append('_');
            r11.append(r10);
            r11.append('`');
            return r11.toString();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010\u0014\u001a\u00020\u00062\n\u0010\u0015\u001a\u00020\u0010\"\u00020\u0003J\u0012\u0010\u0016\u001a\u00020\u00062\n\u0010\u0015\u001a\u00020\u0010\"\u00020\u0003J\u0006\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/room/InvalidationTracker$ObservedTableTracker;", "", "tableCount", "", "(I)V", "needsSync", "", "getNeedsSync", "()Z", "setNeedsSync", "(Z)V", "tableObservers", "", "getTableObservers", "()[J", "triggerStateChanges", "", "triggerStates", "", "getTablesToSync", "onAdded", "tableIds", "onRemoved", "resetTriggerState", "", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ObservedTableTracker {
        public static final int ADD = 1;
        public static final Companion Companion = null;
        public static final int NO_OP = 0;
        public static final int REMOVE = 2;
        private boolean needsSync;
        private final long[] tableObservers;
        private final int[] triggerStateChanges;
        private final boolean[] triggerStates;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/room/InvalidationTracker$ObservedTableTracker$Companion;", "", "()V", "ADD", "", "NO_OP", "REMOVE", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                this();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
        }

        public ObservedTableTracker(int r5) {
            this.tableObservers = new long[r5];
            this.triggerStates = new boolean[r5];
            this.triggerStateChanges = new int[r5];
        }

        public final boolean getNeedsSync() {
            return this.needsSync;
        }

        public final long[] getTableObservers() {
            return this.tableObservers;
        }

        @VisibleForTesting
        @JvmName(name = "getTablesToSync")
        public final int[] getTablesToSync() {
            monitor-enter(this);
        L21:
            th = move-exception;
            throw th;
        L4:
            if (this.needsSync == true) goto L8;
            monitor-exit(this);
            return null;
        L8:
            long[] r5 = this.tableObservers;     // Catch: Throwable -> L21
            int r10 = r5.length;     // Catch: Throwable -> L21
            int r11 = 0;
            int r12 = 0;
        L9:
            if (r11 >= r10) goto L25;
            int r13 = r12 + 1;     // Catch: Throwable -> L21
            int r14 = 1;
            if (r5[r11] <= 0) goto L13;
            boolean r15 = true;
        L14:
            boolean[] r16 = this.triggerStates;     // Catch: Throwable -> L21
            if (r15 == r16[r12]) goto L23;
            int[] r17 = this.triggerStateChanges;     // Catch: Throwable -> L21
            if (r15 == true) goto L20;
            r14 = 2;
        L20:
            r17[r12] = r14;     // Catch: Throwable -> L21
        L24:
            r16[r12] = r15;     // Catch: Throwable -> L21
            r11 = r11 + 1;     // Catch: Throwable -> L21
            r12 = r13;
            goto L9
        L23:
            this.triggerStateChanges[r12] = 0;     // Catch: Throwable -> L21
            goto L24
        L13:
            r15 = false;
            goto L14
        L25:
            this.needsSync = false;     // Catch: Throwable -> L21
            int[] r18 = (int[]) this.triggerStateChanges.clone();     // Catch: Throwable -> L21
            monitor-exit(this);
            return r18;
        }

        public final boolean onAdded(int... r11) {
            Intrinsics.checkNotNullParameter(r11, "tableIds");
            monitor-enter(this);
            int r5 = r11.length;     // Catch: Throwable -> L9
            int r10 = 0;
            boolean r12 = false;
        L5:
            if (r10 >= r5) goto L12;
            int r13 = r11[r10];     // Catch: Throwable -> L9
            long[] r14 = this.tableObservers;     // Catch: Throwable -> L9
            long r15 = r14[r13];     // Catch: Throwable -> L9
            r14[r13] = 1 + r15;     // Catch: Throwable -> L9
            if (r15 != 0) goto L11;
            this.needsSync = true;     // Catch: Throwable -> L9
            r12 = true;
        L11:
            r10 = r10 + 1;     // Catch: Throwable -> L9
            goto L5
        L12:
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L9
            monitor-exit(this);
            return r12;
        L9:
            th = move-exception;
            throw th;
        }

        public final boolean onRemoved(int... r13) {
            Intrinsics.checkNotNullParameter(r13, "tableIds");
            monitor-enter(this);
            int r5 = r13.length;     // Catch: Throwable -> L9
            int r10 = 0;
            boolean r11 = false;
        L5:
            if (r10 >= r5) goto L12;
            int r12 = r13[r10];     // Catch: Throwable -> L9
            long[] r14 = this.tableObservers;     // Catch: Throwable -> L9
            long r15 = r14[r12];     // Catch: Throwable -> L9
            r14[r12] = r15 - 1;     // Catch: Throwable -> L9
            if (r15 != 1) goto L11;
            this.needsSync = true;     // Catch: Throwable -> L9
            r11 = true;
        L11:
            r10 = r10 + 1;     // Catch: Throwable -> L9
            goto L5
        L12:
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L9
            monitor-exit(this);
            return r11;
        L9:
            th = move-exception;
            throw th;
        }

        public final void resetTriggerState() {
            monitor-enter(this);
            Arrays.fill(this.triggerStates, false);     // Catch: Throwable -> L6
            this.needsSync = true;     // Catch: Throwable -> L6
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public final void setNeedsSync(boolean r5) {
            this.needsSync = r5;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0010\"\n\u0000\b&\u0018\u00002\u00020\u0001B#\b\u0014\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005\"\u00020\u0003¢\u0006\u0002\u0010\u0006B\u0015\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\bJ\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H&R\u0014\u0010\t\u001a\u00020\n8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Landroidx/room/InvalidationTracker$Observer;", "", "firstTable", "", "rest", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "tables", "([Ljava/lang/String;)V", "isRemote", "", "isRemote$room_runtime_release", "()Z", "getTables$room_runtime_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "onInvalidated", "", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class Observer {
        private final String[] tables;

        public Observer(String[] r5) {
            Intrinsics.checkNotNullParameter(r5, "tables");
            this.tables = r5;
        }

        public final String[] getTables$room_runtime_release() {
            return this.tables;
        }

        public boolean isRemote$room_runtime_release() {
            return false;
        }

        public abstract void onInvalidated(Set<String> r5);

        public Observer(String r5, String... r10) {
            Intrinsics.checkNotNullParameter(r5, "firstTable");
            Intrinsics.checkNotNullParameter(r10, "rest");
            List r11 = CollectionsKt.createListBuilder();
            CollectionsKt.c(r11, r10);
            r11.add(r5);
            Object[] r12 = CollectionsKt.build(r11).toArray(new String[0]);
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            this((String[]) r12);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001d\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\rH\u0000¢\u0006\u0002\b\u0015J\u001f\u0010\u0016\u001a\u00020\u00122\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001a"}, d2 = {"Landroidx/room/InvalidationTracker$ObserverWrapper;", "", "observer", "Landroidx/room/InvalidationTracker$Observer;", "tableIds", "", "tableNames", "", "", "(Landroidx/room/InvalidationTracker$Observer;[I[Ljava/lang/String;)V", "getObserver$room_runtime_release", "()Landroidx/room/InvalidationTracker$Observer;", "singleTableSet", "", "getTableIds$room_runtime_release", "()[I", "[Ljava/lang/String;", "notifyByTableInvalidStatus", "", "invalidatedTablesIds", "", "notifyByTableInvalidStatus$room_runtime_release", "notifyByTableNames", "tables", "notifyByTableNames$room_runtime_release", "([Ljava/lang/String;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ObserverWrapper {
        private final Observer observer;
        private final Set<String> singleTableSet;
        private final int[] tableIds;
        private final String[] tableNames;

        public ObserverWrapper(Observer r5, int[] r10, String[] r11) {
            Intrinsics.checkNotNullParameter(r5, "observer");
            Intrinsics.checkNotNullParameter(r10, "tableIds");
            Intrinsics.checkNotNullParameter(r11, "tableNames");
            this.observer = r5;
            this.tableIds = r10;
            this.tableNames = r11;
            if (r11.length != 0) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == true) goto L8;
            Set<String> r13 = SetsKt.setOf(r11[0]);
        L9:
            this.singleTableSet = r13;
            if (r10.length != r11.length) goto L13;
            return;
        L13:
            throw new IllegalStateException("Check failed.");
        L8:
            r13 = SetsKt.emptySet();
            goto L9
        L5:
            r12 = false;
            goto L6
        }

        public final Observer getObserver$room_runtime_release() {
            return this.observer;
        }

        public final int[] getTableIds$room_runtime_release() {
            return this.tableIds;
        }

        public final void notifyByTableInvalidStatus$room_runtime_release(Set<Integer> r10) {
            Intrinsics.checkNotNullParameter(r10, "invalidatedTablesIds");
            int[] r5 = this.tableIds;
            int r11 = r5.length;
            if (r11 == 0) goto L17;
            int r12 = 0;
            if (r11 == 1) goto L14;
            Set r13 = SetsKt.createSetBuilder();
            int[] r14 = this.tableIds;
            int r15 = r14.length;
            int r16 = 0;
        L7:
            if (r12 >= r15) goto L12;
            int r17 = r16 + 1;
            if (r10.contains(Integer.valueOf(r14[r12])) == false) goto L11;
            r13.add(this.tableNames[r16]);
        L11:
            r12 = r12 + 1;
            r16 = r17;
            goto L7
        L12:
            Set<String> r18 = SetsKt.build(r13);
        L19:
            if (r18.isEmpty() == true) goto L25;
            this.observer.onInvalidated(r18);
            return;
        L25:
            return;
        L14:
            if (r10.contains(Integer.valueOf(r5[0])) == false) goto L16;
            r18 = this.singleTableSet;
            goto L19
        L16:
            r18 = SetsKt.emptySet();
            goto L19
        L17:
            r18 = SetsKt.emptySet();
            goto L19
        }

        public final void notifyByTableNames$room_runtime_release(String[] r11) {
            Intrinsics.checkNotNullParameter(r11, "tables");
            int r5 = this.tableNames.length;
            if (r5 != 0) goto L5;
            Set<String> r12 = SetsKt.emptySet();
        L25:
            if (r12.isEmpty() == true) goto L34;
            this.observer.onInvalidated(r12);
            return;
        L34:
            return;
        L5:
            if (r5 == 1) goto L16;
            Set r10 = SetsKt.createSetBuilder();
            int r13 = r11.length;
            int r14 = 0;
        L7:
            if (r14 >= r13) goto L15;
            String r15 = r11[r14];
            String[] r16 = this.tableNames;
            int r17 = r16.length;
            int r18 = 0;
        L9:
            if (r18 >= r17) goto L14;
            String r19 = r16[r18];
            if (StringsKt.l(r19, r15) == false) goto L13;
            r10.add(r19);
        L13:
            r18 = r18 + 1;
            goto L9
        L14:
            r14 = r14 + 1;
            goto L7
        L15:
            r12 = SetsKt.build(r10);
            goto L25
        L16:
            int r20 = r11.length;
            int r21 = 0;
        L17:
            if (r21 >= r20) goto L22;
            if (StringsKt.l(r11[r21], this.tableNames[0]) == true) goto L20;
            r21 = r21 + 1;
            goto L17
        L20:
            r12 = this.singleTableSet;
            goto L25
        L22:
            r12 = SetsKt.emptySet();
            goto L25
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Landroidx/room/InvalidationTracker$WeakObserver;", "Landroidx/room/InvalidationTracker$Observer;", "tracker", "Landroidx/room/InvalidationTracker;", "delegate", "(Landroidx/room/InvalidationTracker;Landroidx/room/InvalidationTracker$Observer;)V", "delegateRef", "Ljava/lang/ref/WeakReference;", "getDelegateRef", "()Ljava/lang/ref/WeakReference;", "getTracker", "()Landroidx/room/InvalidationTracker;", "onInvalidated", "", "tables", "", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class WeakObserver extends Observer {
        private final WeakReference<Observer> delegateRef;
        private final InvalidationTracker tracker;

        public WeakObserver(InvalidationTracker r5, Observer r10) {
            Intrinsics.checkNotNullParameter(r5, "tracker");
            Intrinsics.checkNotNullParameter(r10, "delegate");
            super(r10.getTables$room_runtime_release());
            this.tracker = r5;
            this.delegateRef = new WeakReference(r10);
        }

        public final WeakReference<Observer> getDelegateRef() {
            return this.delegateRef;
        }

        public final InvalidationTracker getTracker() {
            return this.tracker;
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(Set<String> r5) {
            Intrinsics.checkNotNullParameter(r5, "tables");
            Observer r10 = this.delegateRef.get();
            if (r10 != null) goto L5;
            this.tracker.removeObserver(this);
            return;
        L5:
            r10.onInvalidated(r5);
        }
    }

    static {
        Companion = new Companion(null);
        TRIGGERS = new String[]{"UPDATE", "DELETE", "INSERT"};
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase r5, Map<String, String> r10, Map<String, Set<String>> r11, String... r12) {
        Intrinsics.checkNotNullParameter(r5, "database");
        Intrinsics.checkNotNullParameter(r10, "shadowTablesMap");
        Intrinsics.checkNotNullParameter(r11, "viewTables");
        Intrinsics.checkNotNullParameter(r12, "tableNames");
        this.database = r5;
        this.shadowTablesMap = r10;
        this.viewTables = r11;
        int r13 = 0;
        this.pendingRefresh = new AtomicBoolean(false);
        this.observedTableTracker = new ObservedTableTracker(r12.length);
        this.invalidationLiveDataContainer = new InvalidationLiveDataContainer(r5);
        this.observerMap = new SafeIterableMap();
        this.syncTriggersLock = new Object();
        this.trackerLock = new Object();
        this.tableIdLookup = new LinkedHashMap();
        int r14 = r12.length;
        String[] r15 = new String[r14];
    L3:
        if (r13 >= r14) goto L12;
        String r16 = r12[r13];
        Locale r17 = Locale.US;
        String r18 = r16.toLowerCase(r17);
        Integer r19 = Integer.valueOf(r13);
        this.tableIdLookup.put(r18, r19);
        String r20 = this.shadowTablesMap.get(r12[r13]);
        if (r20 == null) goto L7;
        String r21 = r20.toLowerCase(r17);
    L8:
        if (r21 == null) goto L11;
        r18 = r21;
    L11:
        r15[r13] = r18;
        r13 = r13 + 1;
        goto L3
    L7:
        r21 = null;
        goto L8
    L12:
        this.tablesNames = r15;
        Iterator<Map.Entry<String, String>> r22 = this.shadowTablesMap.entrySet().iterator();
    L14:
        if (r22.hasNext() == false) goto L18;
        Map.Entry<String, String> r23 = r22.next();
        String r24 = r23.getValue();
        Locale r25 = Locale.US;
        String r26 = r24.toLowerCase(r25);
        if (this.tableIdLookup.containsKey(r26) == false) goto L14;
        String r27 = r23.getKey().toLowerCase(r25);
        Map<String, Integer> r28 = this.tableIdLookup;
        r28.put(r27, (Integer) MapsKt.getValue(r28, r26));
        goto L14
    L18:
        this.refreshRunnable = new InvalidationTracker$refreshRunnable$1(this);
    }

    public static /* synthetic */ void a(InvalidationTracker r5) {
        r5.onAutoCloseCallback();
    }

    public static final /* synthetic */ AutoCloser access$getAutoCloser$p(InvalidationTracker r5) {
        return r5.autoCloser;
    }

    @VisibleForTesting
    public static /* synthetic */ void getRefreshRunnable$annotations() {
    }

    private final void onAutoCloseCallback() {
        Object r5 = this.trackerLock;
        monitor-enter(r5);
        this.initialized = false;     // Catch: Throwable -> L9
        this.observedTableTracker.resetTriggerState();     // Catch: Throwable -> L9
        SupportSQLiteStatement r10 = this.cleanupStatement;     // Catch: Throwable -> L9
        if (r10 == null) goto L11;
        r10.close();     // Catch: Throwable -> L9
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L11:
        monitor-exit(r5);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private final String[] resolveViews(String[] r10) {
        Set r5 = SetsKt.createSetBuilder();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        String r13 = r10[r12];
        Map<String, Set<String>> r14 = this.viewTables;
        Locale r15 = Locale.US;
        if (r14.containsKey(r13.toLowerCase(r15)) == false) goto L7;
        Set<String> r16 = this.viewTables.get(r13.toLowerCase(r15));
        Intrinsics.checkNotNull(r16);
        r5.addAll(r16);
    L8:
        r12 = r12 + 1;
        goto L3
    L7:
        r5.add(r13);
        goto L8
    L9:
        Object[] r17 = SetsKt.build(r5).toArray(new String[0]);
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) r17;
    }

    private final void startTrackingTable(SupportSQLiteDatabase r10, int r11) {
        r10.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + r11 + ", 0)");
        String r12 = this.tablesNames[r11];
        String[] r5 = TRIGGERS;
        int r13 = r5.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        String r15 = r5[r14];
        StringBuilder r16 = new StringBuilder("CREATE TEMP TRIGGER IF NOT EXISTS ");
        r16.append(Companion.getTriggerName$room_runtime_release(r12, r15));
        r16.append(" AFTER ");
        androidx.constraintlayout.motion.widget.a.C(r16, r15, " ON `", r12, "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = ");
        r16.append(r11);
        r16.append(" AND invalidated = 0; END");
        r10.execSQL(r16.toString());
        r14 = r14 + 1;
        goto L3
    }

    private final void stopTrackingTable(SupportSQLiteDatabase r10, int r11) {
        String r5 = this.tablesNames[r11];
        String[] r12 = TRIGGERS;
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r10.execSQL("DROP TRIGGER IF EXISTS " + Companion.getTriggerName$room_runtime_release(r5, r12[r14]));
        r14 = r14 + 1;
        goto L3
    }

    private final String[] validateAndResolveTableNames(String[] r10) {
        String[] r11 = resolveViews(r10);
        int r5 = r11.length;
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L9;
        String r13 = r11[r12];
        if (this.tableIdLookup.containsKey(r13.toLowerCase(Locale.US)) == false) goto L8;
        r12 = r12 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException("There is no table with name ".concat(r13).toString());
    L9:
        return r11;
    }

    @SuppressLint({"RestrictedApi"})
    @WorkerThread
    public void addObserver(Observer r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        String[] r5 = resolveViews(r10.getTables$room_runtime_release());
        ArrayList r11 = new ArrayList(r5.length);
        int r12 = r5.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        String r14 = r5[r13];
        Integer r15 = this.tableIdLookup.get(r14.toLowerCase(Locale.US));
        if (r15 == null) goto L8;
        r11.add(r15);
        r13 = r13 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException("There is no table with name ".concat(r14));
    L9:
        int[] r16 = CollectionsKt.toIntArray(r11);
        ObserverWrapper r17 = new ObserverWrapper(r10, r16, r5);
        SafeIterableMap<Observer, ObserverWrapper> r18 = this.observerMap;
        monitor-enter(r18);
        ObserverWrapper r19 = this.observerMap.putIfAbsent(r10, r17);     // Catch: Throwable -> L18
        monitor-exit(r18);
        if (r19 == null) goto L15;
        return;
    L15:
        if (this.observedTableTracker.onAdded(Arrays.copyOf(r16, r16.length)) == false) goto L26;
        syncTriggers$room_runtime_release();
        return;
    L26:
        return;
    L18:
        th = move-exception;
        throw th;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addWeakObserver(Observer r5) {
        Intrinsics.checkNotNullParameter(r5, "observer");
        addObserver(new WeakObserver(this, r5));
    }

    @Deprecated(message = "Use [createLiveData(String[], boolean, Callable)]")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] r5, Callable<T> r10) {
        Intrinsics.checkNotNullParameter(r5, "tableNames");
        Intrinsics.checkNotNullParameter(r10, "computeFunction");
        return createLiveData(r5, false, r10);
    }

    public final boolean ensureInitialization$room_runtime_release() {
        if (this.database.isOpenInternal() == true) goto L6;
        return false;
    L6:
        if (this.initialized == true) goto L9;
        this.database.getOpenHelper().getWritableDatabase();
    L9:
        if (this.initialized == true) goto L12;
        Log.e(Room.LOG_TAG, "database is not initialized even though it is open");
        return false;
    L12:
        return true;
    }

    public final SupportSQLiteStatement getCleanupStatement$room_runtime_release() {
        return this.cleanupStatement;
    }

    public final RoomDatabase getDatabase$room_runtime_release() {
        return this.database;
    }

    public final SafeIterableMap<Observer, ObserverWrapper> getObserverMap$room_runtime_release() {
        return this.observerMap;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final AtomicBoolean getPendingRefresh() {
        return this.pendingRefresh;
    }

    public final Map<String, Integer> getTableIdLookup$room_runtime_release() {
        return this.tableIdLookup;
    }

    public final String[] getTablesNames$room_runtime_release() {
        return this.tablesNames;
    }

    public final void internalInit$room_runtime_release(SupportSQLiteDatabase r5) {
        Intrinsics.checkNotNullParameter(r5, "database");
        Object r10 = this.trackerLock;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.initialized == false) goto L11;
        Log.e(Room.LOG_TAG, "Invalidation tracker is initialized twice :/.");     // Catch: Throwable -> L9
        monitor-exit(r10);
        return;
    L11:
        r5.execSQL("PRAGMA temp_store = MEMORY;");     // Catch: Throwable -> L9
        r5.execSQL("PRAGMA recursive_triggers='ON';");     // Catch: Throwable -> L9
        r5.execSQL(CREATE_TRACKING_TABLE_SQL);     // Catch: Throwable -> L9
        syncTriggers$room_runtime_release(r5);     // Catch: Throwable -> L9
        this.cleanupStatement = r5.compileStatement(RESET_UPDATED_TABLES_SQL);     // Catch: Throwable -> L9
        this.initialized = true;     // Catch: Throwable -> L9
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting(otherwise = 3)
    public final void notifyObserversByTableNames(String... r5) {
        Intrinsics.checkNotNullParameter(r5, "tables");
        SafeIterableMap<Observer, ObserverWrapper> r10 = this.observerMap;
        monitor-enter(r10);
        Iterator<Map.Entry<K, V>> r11 = this.observerMap.iterator();     // Catch: Throwable -> L10
    L6:
        if (r11.hasNext() == false) goto L12;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: Throwable -> L10
        Observer r13 = (Observer) r12.getKey();     // Catch: Throwable -> L10
        ObserverWrapper r14 = (ObserverWrapper) r12.getValue();     // Catch: Throwable -> L10
        if (r13.isRemote$room_runtime_release() == true) goto L6;
        r14.notifyByTableNames$room_runtime_release(r5);     // Catch: Throwable -> L10
        goto L6
    L12:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r10);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void refreshVersionsAsync() {
        if (this.pendingRefresh.compareAndSet(false, true) == false) goto L9;
        AutoCloser r5 = this.autoCloser;
        if (r5 == null) goto L7;
        r5.incrementCountAndEnsureDbIsOpen();
    L7:
        this.database.getQueryExecutor().execute(this.refreshRunnable);
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @WorkerThread
    public void refreshVersionsSync() {
        AutoCloser r5 = this.autoCloser;
        if (r5 == null) goto L5;
        r5.incrementCountAndEnsureDbIsOpen();
    L5:
        syncTriggers$room_runtime_release();
        this.refreshRunnable.run();
    }

    @SuppressLint({"RestrictedApi"})
    @WorkerThread
    public void removeObserver(Observer r5) {
        Intrinsics.checkNotNullParameter(r5, "observer");
        SafeIterableMap<Observer, ObserverWrapper> r10 = this.observerMap;
        monitor-enter(r10);
        ObserverWrapper r11 = this.observerMap.remove(r5);     // Catch: Throwable -> L11
        monitor-exit(r10);
        if (r11 == null) goto L16;
        ObservedTableTracker r12 = this.observedTableTracker;
        int[] r13 = r11.getTableIds$room_runtime_release();
        if (r12.onRemoved(Arrays.copyOf(r13, r13.length)) == false) goto L17;
        syncTriggers$room_runtime_release();
        return;
    L17:
        return;
    L16:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void setAutoCloser$room_runtime_release(AutoCloser r5) {
        Intrinsics.checkNotNullParameter(r5, "autoCloser");
        this.autoCloser = r5;
        r5.setAutoCloseCallback(new androidx.fragment.app.d(this, 3));
    }

    public final void setCleanupStatement$room_runtime_release(SupportSQLiteStatement r5) {
        this.cleanupStatement = r5;
    }

    public final void startMultiInstanceInvalidation$room_runtime_release(Context r10, String r11, Intent r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "name");
        Intrinsics.checkNotNullParameter(r12, "serviceIntent");
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(r10, r11, r12, this, this.database.getQueryExecutor());
    }

    public final void stopMultiInstanceInvalidation$room_runtime_release() {
        MultiInstanceInvalidationClient r5 = this.multiInstanceInvalidationClient;
        if (r5 == null) goto L5;
        r5.stop();
    L5:
        this.multiInstanceInvalidationClient = null;
    }

    public final void syncTriggers$room_runtime_release(SupportSQLiteDatabase r11) {
        Intrinsics.checkNotNullParameter(r11, "database");
        if (r11.inTransaction() == false) goto L52;
        return;
    L52:
        Lock r5 = this.database.getCloseLock$room_runtime_release();     // Catch: SQLiteException -> L13 IllegalStateException -> L15
        r5.lock();     // Catch: SQLiteException -> L13 IllegalStateException -> L15
        Object r10 = this.syncTriggersLock;     // Catch: Throwable -> L17
        monitor-enter(r10);     // Catch: Throwable -> L17
        int[] r12 = this.observedTableTracker.getTablesToSync();     // Catch: Throwable -> L37
        if (r12 != null) goto L19;
        monitor-exit(r10);     // Catch: Throwable -> L17
        r5.unlock();     // Catch: SQLiteException -> L13 IllegalStateException -> L15
        return;
    L19:
        Companion.beginTransactionInternal$room_runtime_release(r11);     // Catch: Throwable -> L37
        int r13 = r12.length;     // Catch: Throwable -> L28
        int r14 = 0;
        int r15 = 0;
    L21:
        if (r14 >= r13) goto L32;
        int r16 = r12[r14];     // Catch: Throwable -> L28
        int r17 = r15 + 1;     // Catch: Throwable -> L28
        if (r16 != 1) goto L25;
        startTrackingTable(r11, r15);     // Catch: Throwable -> L28
    L31:
        r14 = r14 + 1;     // Catch: Throwable -> L28
        r15 = r17;
        goto L21
    L25:
        if (r16 != 2) goto L31;
        stopTrackingTable(r11, r15);     // Catch: Throwable -> L28
        goto L31
    L32:
        r11.setTransactionSuccessful();     // Catch: Throwable -> L28
        r11.endTransaction();     // Catch: Throwable -> L37
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(r10);     // Catch: Throwable -> L17
        r5.unlock();     // Catch: SQLiteException -> L13 IllegalStateException -> L15
        return;
    L28:
        th = move-exception;
        r11.endTransaction();     // Catch: Throwable -> L37
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r5.unlock();     // Catch: SQLiteException -> L13 IllegalStateException -> L15
        throw th;     // Catch: SQLiteException -> L13 IllegalStateException -> L15
    L13:
        e = move-exception;
        Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e);
        return;
    L15:
        e = move-exception;
        Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] r5, boolean r10, Callable<T> r11) {
        Intrinsics.checkNotNullParameter(r5, "tableNames");
        Intrinsics.checkNotNullParameter(r11, "computeFunction");
        return this.invalidationLiveDataContainer.create(validateAndResolveTableNames(r5), r10, r11);
    }

    public final void syncTriggers$room_runtime_release() {
        if (this.database.isOpenInternal() == true) goto L5;
        return;
    L5:
        syncTriggers$room_runtime_release(this.database.getOpenHelper().getWritableDatabase());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase r5, String... r10) {
        Intrinsics.checkNotNullParameter(r5, "database");
        Intrinsics.checkNotNullParameter(r10, "tableNames");
        this(r5, MapsKt.emptyMap(), MapsKt.emptyMap(), (String[]) Arrays.copyOf(r10, r10.length));
    }
}
