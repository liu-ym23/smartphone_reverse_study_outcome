package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.crash.tracker.ActivityLifecycle;
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

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getRESET_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getSELECT_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        public final void beginTransactionInternal$room_runtime_release(SupportSQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "database");
            if (Build.VERSION.SDK_INT >= 16) goto L5;
        L7:
            r10.beginTransaction();
            return;
        L5:
            if (r10.isWriteAheadLoggingEnabled() == false) goto L7;
            r10.beginTransactionNonExclusive();
        }

        public final String getTriggerName$room_runtime_release(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "tableName");
            Intrinsics.checkNotNullParameter(r11, "triggerType");
            return "`room_table_modification_trigger_" + r10 + '_' + r11 + '`';
        }
    }

    public static final class ObservedTableTracker {
        public static final int ADD = 1;
        public static final Companion Companion = null;
        public static final int NO_OP = 0;
        public static final int REMOVE = 2;
        private boolean needsSync;
        private final long[] tableObservers;
        private final int[] triggerStateChanges;
        private final boolean[] triggerStates;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public ObservedTableTracker(int r10) {
            this.tableObservers = new long[r10];
            this.triggerStates = new boolean[r10];
            this.triggerStateChanges = new int[r10];
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
        L26:
            th = move-exception;
            throw th;
        L4:
            if (this.needsSync == false) goto L6;
            long[] r10 = this.tableObservers;     // Catch: Throwable -> L26
            int r11 = r10.length;     // Catch: Throwable -> L26
            int r12 = 0;
            int r13 = 0;
        L9:
            if (r12 >= r11) goto L23;
            int r14 = r13 + 1;     // Catch: Throwable -> L26
            int r15 = 1;
            if (r10[r12] <= 0) goto L13;
            boolean r16 = true;
        L14:
            boolean[] r17 = this.triggerStates;     // Catch: Throwable -> L26
            if (r16 == r17[r13]) goto L21;
            int[] r18 = this.triggerStateChanges;     // Catch: Throwable -> L26
            if (r16 == true) goto L20;
            r15 = 2;
        L20:
            r18[r13] = r15;     // Catch: Throwable -> L26
        L22:
            r17[r13] = r16;     // Catch: Throwable -> L26
            r12 = r12 + 1;     // Catch: Throwable -> L26
            r13 = r14;
            goto L9
        L21:
            this.triggerStateChanges[r13] = 0;     // Catch: Throwable -> L26
            goto L22
        L13:
            r16 = false;
            goto L14
        L23:
            this.needsSync = false;     // Catch: Throwable -> L26
            int[] r19 = (int[]) this.triggerStateChanges.clone();     // Catch: Throwable -> L26
            monitor-exit(this);
            return r19;
        L6:
            monitor-exit(this);
            return null;
        }

        public final boolean onAdded(int... r10) {
            Intrinsics.checkNotNullParameter(r10, "tableIds");
            monitor-enter(this);
            int r11 = r10.length;     // Catch: Throwable -> L13
            int r12 = 0;
            boolean r13 = false;
        L5:
            if (r12 >= r11) goto L10;
            int r14 = r10[r12];     // Catch: Throwable -> L13
            long[] r15 = this.tableObservers;     // Catch: Throwable -> L13
            long r16 = r15[r14];     // Catch: Throwable -> L13
            r15[r14] = 1 + r16;     // Catch: Throwable -> L13
            if (r16 != 0) goto L9;
            this.needsSync = true;     // Catch: Throwable -> L13
            r13 = true;
        L9:
            r12 = r12 + 1;     // Catch: Throwable -> L13
            goto L5
        L10:
            Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L13
            monitor-exit(this);
            return r13;
        L13:
            th = move-exception;
            throw th;
        }

        public final boolean onRemoved(int... r12) {
            Intrinsics.checkNotNullParameter(r12, "tableIds");
            monitor-enter(this);
            int r10 = r12.length;     // Catch: Throwable -> L13
            int r11 = 0;
            boolean r13 = false;
        L5:
            if (r11 >= r10) goto L10;
            int r14 = r12[r11];     // Catch: Throwable -> L13
            long[] r15 = this.tableObservers;     // Catch: Throwable -> L13
            long r16 = r15[r14];     // Catch: Throwable -> L13
            r15[r14] = r16 - 1;     // Catch: Throwable -> L13
            if (r16 != 1) goto L9;
            this.needsSync = true;     // Catch: Throwable -> L13
            r13 = true;
        L9:
            r11 = r11 + 1;     // Catch: Throwable -> L13
            goto L5
        L10:
            Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L13
            monitor-exit(this);
            return r13;
        L13:
            th = move-exception;
            throw th;
        }

        public final void resetTriggerState() {
            monitor-enter(this);
            Arrays.fill(this.triggerStates, false);     // Catch: Throwable -> L6
            this.needsSync = true;     // Catch: Throwable -> L6
            Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public final void setNeedsSync(boolean r10) {
            this.needsSync = r10;
        }
    }

    public static abstract class Observer {
        private final String[] tables;

        protected Observer(String r10, String... r11) {
            Intrinsics.checkNotNullParameter(r10, "firstTable");
            Intrinsics.checkNotNullParameter(r11, "rest");
            List r12 = CollectionsKt.createListBuilder();
            CollectionsKt.addAll(r12, r11);
            r12.add(r10);
            Object[] r13 = CollectionsKt.build(r12).toArray(new String[0]);
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            this((String[]) r13);
        }

        public Observer(String[] r10) {
            Intrinsics.checkNotNullParameter(r10, "tables");
            this.tables = r10;
        }

        public final String[] getTables$room_runtime_release() {
            return this.tables;
        }

        public boolean isRemote$room_runtime_release() {
            return false;
        }

        public abstract void onInvalidated(Set<String> r10);
    }

    public static final class ObserverWrapper {
        private final Observer observer;
        private final Set<String> singleTableSet;
        private final int[] tableIds;
        private final String[] tableNames;

        public ObserverWrapper(Observer r10, int[] r11, String[] r12) {
            Intrinsics.checkNotNullParameter(r10, "observer");
            Intrinsics.checkNotNullParameter(r11, "tableIds");
            Intrinsics.checkNotNullParameter(r12, "tableNames");
            this.observer = r10;
            this.tableIds = r11;
            this.tableNames = r12;
            boolean r13 = true;
            if (r12.length != 0) goto L5;
            boolean r14 = true;
        L7:
            if ((!r14) == false) goto L9;
            Set<String> r15 = SetsKt.setOf(r12[0]);
        L10:
            this.singleTableSet = r15;
            if (r11.length == r12.length) goto L14;
            r13 = false;
        L14:
            if (r13 == false) goto L17;
            return;
        L17:
            throw new IllegalStateException("Check failed.".toString());
        L9:
            r15 = SetsKt.emptySet();
            goto L10
        L5:
            r14 = false;
            goto L7
        }

        public final Observer getObserver$room_runtime_release() {
            return this.observer;
        }

        public final int[] getTableIds$room_runtime_release() {
            return this.tableIds;
        }

        public final void notifyByTableInvalidStatus$room_runtime_release(Set<Integer> r10) {
            Intrinsics.checkNotNullParameter(r10, "invalidatedTablesIds");
            int[] r11 = this.tableIds;
            int r12 = r11.length;
            if (r12 == 0) goto L16;
            int r13 = 0;
            if (r12 == 1) goto L14;
            Set r14 = SetsKt.createSetBuilder();
            int[] r15 = this.tableIds;
            int r16 = r15.length;
            int r17 = 0;
        L7:
            if (r13 >= r16) goto L12;
            int r18 = r17 + 1;
            if (r10.contains(Integer.valueOf(r15[r13])) == false) goto L11;
            r14.add(this.tableNames[r17]);
        L11:
            r13 = r13 + 1;
            r17 = r18;
            goto L7
        L12:
            Set<String> r19 = SetsKt.build(r14);
        L18:
            if ((!r19.isEmpty()) == false) goto L24;
            this.observer.onInvalidated(r19);
            return;
        L24:
            return;
        L14:
            if (r10.contains(Integer.valueOf(r11[0])) == false) goto L16;
            r19 = this.singleTableSet;
        L16:
            r19 = SetsKt.emptySet();
            goto L18
        }

        public final void notifyByTableNames$room_runtime_release(String[] r12) {
            Intrinsics.checkNotNullParameter(r12, "tables");
            int r10 = this.tableNames.length;
            if (r10 == 0) goto L24;
            boolean r11 = false;
            if (r10 == 1) goto L16;
            Set r13 = SetsKt.createSetBuilder();
            int r14 = r12.length;
            int r15 = 0;
        L7:
            if (r15 >= r14) goto L15;
            String r16 = r12[r15];
            String[] r17 = this.tableNames;
            int r18 = r17.length;
            int r19 = 0;
        L9:
            if (r19 >= r18) goto L14;
            String r20 = r17[r19];
            if (StringsKt.equals(r20, r16, true) == false) goto L13;
            r13.add(r20);
        L13:
            r19 = r19 + 1;
            goto L9
        L14:
            r15 = r15 + 1;
            goto L7
        L15:
            Set<String> r110 = SetsKt.build(r13);
        L26:
            if ((!r110.isEmpty()) == false) goto L35;
            this.observer.onInvalidated(r110);
            return;
        L35:
            return;
        L16:
            int r21 = r12.length;
            int r22 = 0;
        L17:
            if (r22 >= r21) goto L22;
            if (StringsKt.equals(r12[r22], this.tableNames[0], true) == true) goto L20;
            r22 = r22 + 1;
            goto L17
        L20:
            r11 = true;
        L22:
            if (r11 == false) goto L24;
            r110 = this.singleTableSet;
        L24:
            r110 = SetsKt.emptySet();
            goto L26
        }
    }

    public static final class WeakObserver extends Observer {
        private final WeakReference<Observer> delegateRef;
        private final InvalidationTracker tracker;

        public WeakObserver(InvalidationTracker r10, Observer r11) {
            Intrinsics.checkNotNullParameter(r10, "tracker");
            Intrinsics.checkNotNullParameter(r11, "delegate");
            super(r11.getTables$room_runtime_release());
            this.tracker = r10;
            this.delegateRef = new WeakReference(r11);
        }

        public final WeakReference<Observer> getDelegateRef() {
            return this.delegateRef;
        }

        public final InvalidationTracker getTracker() {
            return this.tracker;
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(Set<String> r10) {
            Intrinsics.checkNotNullParameter(r10, "tables");
            Observer r11 = this.delegateRef.get();
            if (r11 != null) goto L5;
            this.tracker.removeObserver(this);
            return;
        L5:
            r11.onInvalidated(r10);
        }
    }

    static {
        Companion = new Companion(null);
        TRIGGERS = new String[]{"UPDATE", "DELETE", "INSERT"};
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase r10, Map<String, String> r11, Map<String, Set<String>> r12, String... r13) {
        Intrinsics.checkNotNullParameter(r10, "database");
        Intrinsics.checkNotNullParameter(r11, "shadowTablesMap");
        Intrinsics.checkNotNullParameter(r12, "viewTables");
        Intrinsics.checkNotNullParameter(r13, "tableNames");
        this.database = r10;
        this.shadowTablesMap = r11;
        this.viewTables = r12;
        int r14 = 0;
        this.pendingRefresh = new AtomicBoolean(false);
        this.observedTableTracker = new ObservedTableTracker(r13.length);
        this.invalidationLiveDataContainer = new InvalidationLiveDataContainer(r10);
        this.observerMap = new SafeIterableMap();
        this.syncTriggersLock = new Object();
        this.trackerLock = new Object();
        this.tableIdLookup = new LinkedHashMap();
        int r15 = r13.length;
        String[] r16 = new String[r15];
    L4:
        if (r14 >= r15) goto L13;
        String r17 = r13[r14];
        Locale r18 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r18, "US");
        String r19 = r17.toLowerCase(r18);
        Intrinsics.checkNotNullExpressionValue(r19, "this as java.lang.String).toLowerCase(locale)");
        Integer r20 = Integer.valueOf(r14);
        this.tableIdLookup.put(r19, r20);
        String r21 = this.shadowTablesMap.get(r13[r14]);
        if (r21 == null) goto L8;
        Intrinsics.checkNotNullExpressionValue(r18, "US");
        String r22 = r21.toLowerCase(r18);
        Intrinsics.checkNotNullExpressionValue(r22, "this as java.lang.String).toLowerCase(locale)");
    L9:
        if (r22 == null) goto L12;
        r19 = r22;
    L12:
        r16[r14] = r19;
        r14 = r14 + 1;
        goto L4
    L8:
        r22 = null;
        goto L9
    L13:
        this.tablesNames = r16;
        Iterator<Map.Entry<String, String>> r23 = this.shadowTablesMap.entrySet().iterator();
    L15:
        if (r23.hasNext() == false) goto L19;
        Map.Entry<String, String> r24 = r23.next();
        String r25 = r24.getValue();
        Locale r110 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r110, "US");
        String r26 = r25.toLowerCase(r110);
        Intrinsics.checkNotNullExpressionValue(r26, "this as java.lang.String).toLowerCase(locale)");
        if (this.tableIdLookup.containsKey(r26) == false) goto L15;
        String r27 = r24.getKey();
        Intrinsics.checkNotNullExpressionValue(r110, "US");
        String r28 = r27.toLowerCase(r110);
        Intrinsics.checkNotNullExpressionValue(r28, "this as java.lang.String).toLowerCase(locale)");
        Map<String, Integer> r111 = this.tableIdLookup;
        r111.put(r28, (Integer) MapsKt.getValue(r111, r26));
        goto L15
    L19:
        this.refreshRunnable = new InvalidationTracker$refreshRunnable$1(this);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase r10, String... r11) {
        Intrinsics.checkNotNullParameter(r10, "database");
        Intrinsics.checkNotNullParameter(r11, "tableNames");
        this(r10, MapsKt.emptyMap(), MapsKt.emptyMap(), (String[]) Arrays.copyOf(r11, r11.length));
    }

    public static final /* synthetic */ AutoCloser access$getAutoCloser$p(InvalidationTracker r10) {
        return r10.autoCloser;
    }

    @VisibleForTesting
    public static /* synthetic */ void getRefreshRunnable$annotations() {
    }

    private final String[] resolveViews(String[] r11) {
        Set r10 = SetsKt.createSetBuilder();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        String r14 = r11[r13];
        Map<String, Set<String>> r15 = this.viewTables;
        Locale r16 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r16, "US");
        String r17 = r14.toLowerCase(r16);
        Intrinsics.checkNotNullExpressionValue(r17, "this as java.lang.String).toLowerCase(locale)");
        if (r15.containsKey(r17) == false) goto L7;
        Map<String, Set<String>> r18 = this.viewTables;
        Intrinsics.checkNotNullExpressionValue(r16, "US");
        String r19 = r14.toLowerCase(r16);
        Intrinsics.checkNotNullExpressionValue(r19, "this as java.lang.String).toLowerCase(locale)");
        Set<String> r20 = r18.get(r19);
        Intrinsics.checkNotNull(r20);
        r10.addAll(r20);
    L8:
        r13 = r13 + 1;
        goto L3
    L7:
        r10.add(r14);
        goto L8
    L9:
        Object[] r110 = SetsKt.build(r10).toArray(new String[0]);
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) r110;
    }

    private final void startTrackingTable(SupportSQLiteDatabase r10, int r11) {
        r10.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + r11 + ", 0)");
        String r12 = this.tablesNames[r11];
        String[] r13 = TRIGGERS;
        int r14 = r13.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        String r16 = r13[r15];
        String r17 = "CREATE TEMP TRIGGER IF NOT EXISTS " + Companion.getTriggerName$room_runtime_release(r12, r16) + " AFTER " + r16 + " ON `" + r12 + "` BEGIN UPDATE " + UPDATE_TABLE_NAME + " SET " + INVALIDATED_COLUMN_NAME + " = 1 WHERE " + TABLE_ID_COLUMN_NAME + " = " + r11 + " AND " + INVALIDATED_COLUMN_NAME + " = 0; END";
        Intrinsics.checkNotNullExpressionValue(r17, "StringBuilder().apply(builderAction).toString()");
        r10.execSQL(r17);
        r15 = r15 + 1;
        goto L3
    }

    private final void stopTrackingTable(SupportSQLiteDatabase r10, int r11) {
        String r12 = this.tablesNames[r11];
        String[] r13 = TRIGGERS;
        int r14 = r13.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        String r16 = "DROP TRIGGER IF EXISTS " + Companion.getTriggerName$room_runtime_release(r12, r13[r15]);
        Intrinsics.checkNotNullExpressionValue(r16, "StringBuilder().apply(builderAction).toString()");
        r10.execSQL(r16);
        r15 = r15 + 1;
        goto L3
    }

    private final String[] validateAndResolveTableNames(String[] r10) {
        String[] r11 = resolveViews(r10);
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        String r14 = r11[r13];
        Map<String, Integer> r15 = this.tableIdLookup;
        Locale r16 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r16, "US");
        String r17 = r14.toLowerCase(r16);
        Intrinsics.checkNotNullExpressionValue(r17, "this as java.lang.String).toLowerCase(locale)");
        if (r15.containsKey(r17) == false) goto L8;
        r13 = r13 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException(("There is no table with name " + r14).toString());
    L9:
        return r11;
    }

    @SuppressLint({"RestrictedApi"})
    @WorkerThread
    public void addObserver(Observer r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        String[] r11 = resolveViews(r10.getTables$room_runtime_release());
        ArrayList r12 = new ArrayList(r11.length);
        int r13 = r11.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L9;
        String r15 = r11[r14];
        Map<String, Integer> r16 = this.tableIdLookup;
        Locale r17 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r17, "US");
        String r18 = r15.toLowerCase(r17);
        Intrinsics.checkNotNullExpressionValue(r18, "this as java.lang.String).toLowerCase(locale)");
        Integer r19 = r16.get(r18);
        if (r19 == null) goto L8;
        r12.add(Integer.valueOf(r19.intValue()));
        r14 = r14 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException("There is no table with name " + r15);
    L9:
        int[] r20 = CollectionsKt.toIntArray(r12);
        ObserverWrapper r21 = new ObserverWrapper(r10, r20, r11);
        SafeIterableMap<Observer, ObserverWrapper> r22 = this.observerMap;
        monitor-enter(r22);
        ObserverWrapper r23 = this.observerMap.putIfAbsent(r10, r21);     // Catch: Throwable -> L18
        monitor-exit(r22);
        if (r23 == null) goto L15;
        return;
    L15:
        if (this.observedTableTracker.onAdded(Arrays.copyOf(r20, r20.length)) == false) goto L26;
        syncTriggers$room_runtime_release();
        return;
    L26:
        return;
    L18:
        th = move-exception;
        throw th;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addWeakObserver(Observer r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        addObserver(new WeakObserver(this, r10));
    }

    @Deprecated(message = "Use [createLiveData(String[], boolean, Callable)]")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] r10, Callable<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "tableNames");
        Intrinsics.checkNotNullParameter(r11, "computeFunction");
        return createLiveData(r10, false, r11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] r10, boolean r11, Callable<T> r12) {
        Intrinsics.checkNotNullParameter(r10, "tableNames");
        Intrinsics.checkNotNullParameter(r12, "computeFunction");
        return this.invalidationLiveDataContainer.create(validateAndResolveTableNames(r10), r11, r12);
    }

    public final boolean ensureInitialization$room_runtime_release() {
        if (this.database.isOpen() == true) goto L6;
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

    public final void internalInit$room_runtime_release(SupportSQLiteDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "database");
        Object r11 = this.trackerLock;
        monitor-enter(r11);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.initialized == false) goto L9;
        Log.e(Room.LOG_TAG, "Invalidation tracker is initialized twice :/.");     // Catch: Throwable -> L12
        monitor-exit(r11);
        return;
    L9:
        r10.execSQL("PRAGMA temp_store = MEMORY;");     // Catch: Throwable -> L12
        r10.execSQL("PRAGMA recursive_triggers='ON';");     // Catch: Throwable -> L12
        r10.execSQL(CREATE_TRACKING_TABLE_SQL);     // Catch: Throwable -> L12
        syncTriggers$room_runtime_release(r10);     // Catch: Throwable -> L12
        this.cleanupStatement = r10.compileStatement(RESET_UPDATED_TABLES_SQL);     // Catch: Throwable -> L12
        this.initialized = true;     // Catch: Throwable -> L12
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting(otherwise = 3)
    public final void notifyObserversByTableNames(String... r10) {
        Intrinsics.checkNotNullParameter(r10, "tables");
        SafeIterableMap<Observer, ObserverWrapper> r11 = this.observerMap;
        monitor-enter(r11);
        Iterator<Map.Entry<K, V>> r12 = this.observerMap.iterator();     // Catch: Throwable -> L13
    L6:
        if (r12.hasNext() == false) goto L10;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r13, "(observer, wrapper)");     // Catch: Throwable -> L13
        Observer r14 = (Observer) r13.getKey();     // Catch: Throwable -> L13
        ObserverWrapper r15 = (ObserverWrapper) r13.getValue();     // Catch: Throwable -> L13
        if (r14.isRemote$room_runtime_release() == true) goto L6;
        r15.notifyByTableNames$room_runtime_release(r10);     // Catch: Throwable -> L13
        goto L6
    L10:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r11);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void onAutoCloseCallback$room_runtime_release() {
        Object r10 = this.trackerLock;
        monitor-enter(r10);
        this.initialized = false;     // Catch: Throwable -> L8
        this.observedTableTracker.resetTriggerState();     // Catch: Throwable -> L8
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r10);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void refreshVersionsAsync() {
        if (this.pendingRefresh.compareAndSet(false, true) == false) goto L9;
        AutoCloser r10 = this.autoCloser;
        if (r10 == null) goto L7;
        r10.incrementCountAndEnsureDbIsOpen();
    L7:
        this.database.getQueryExecutor().execute(this.refreshRunnable);
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @WorkerThread
    public void refreshVersionsSync() {
        AutoCloser r10 = this.autoCloser;
        if (r10 == null) goto L5;
        r10.incrementCountAndEnsureDbIsOpen();
    L5:
        syncTriggers$room_runtime_release();
        this.refreshRunnable.run();
    }

    @SuppressLint({"RestrictedApi"})
    @WorkerThread
    public void removeObserver(Observer r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        SafeIterableMap<Observer, ObserverWrapper> r11 = this.observerMap;
        monitor-enter(r11);
        ObserverWrapper r12 = this.observerMap.remove(r10);     // Catch: Throwable -> L11
        monitor-exit(r11);
        if (r12 == null) goto L16;
        ObservedTableTracker r13 = this.observedTableTracker;
        int[] r14 = r12.getTableIds$room_runtime_release();
        if (r13.onRemoved(Arrays.copyOf(r14, r14.length)) == false) goto L17;
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

    public final void setAutoCloser$room_runtime_release(AutoCloser r10) {
        Intrinsics.checkNotNullParameter(r10, "autoCloser");
        this.autoCloser = r10;
        r10.setAutoCloseCallback(new c(this));
    }

    public final void setCleanupStatement$room_runtime_release(SupportSQLiteStatement r10) {
        this.cleanupStatement = r10;
    }

    public final void startMultiInstanceInvalidation$room_runtime_release(Context r10, String r11, Intent r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "serviceIntent");
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(r10, r11, r12, this, this.database.getQueryExecutor());
    }

    public final void stopMultiInstanceInvalidation$room_runtime_release() {
        MultiInstanceInvalidationClient r10 = this.multiInstanceInvalidationClient;
        if (r10 == null) goto L5;
        r10.stop();
    L5:
        this.multiInstanceInvalidationClient = null;
    }

    public final void syncTriggers$room_runtime_release() {
        if (this.database.isOpen() == true) goto L5;
        return;
    L5:
        syncTriggers$room_runtime_release(this.database.getOpenHelper().getWritableDatabase());
    }

    public final void syncTriggers$room_runtime_release(SupportSQLiteDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "database");
        if (r10.inTransaction() == false) goto L45;
        return;
    L45:
        Lock r11 = this.database.getCloseLock$room_runtime_release();     // Catch: Throwable -> L38
        r11.lock();     // Catch: Throwable -> L38
        Object r12 = this.syncTriggersLock;     // Catch: Throwable -> L35
        monitor-enter(r12);     // Catch: Throwable -> L35
        int[] r13 = this.observedTableTracker.getTablesToSync();     // Catch: Throwable -> L32
        if (r13 != null) goto L13;
        monitor-exit(r12);     // Catch: Throwable -> L35
        r11.unlock();     // Catch: Throwable -> L38 Throwable -> L38
        return;
    L13:
        Companion.beginTransactionInternal$room_runtime_release(r10);     // Catch: Throwable -> L32
        int r14 = r13.length;     // Catch: Throwable -> L29
        int r15 = 0;
        int r16 = 0;
    L15:
        if (r15 >= r14) goto L24;
        int r17 = r13[r15];     // Catch: Throwable -> L29
        int r18 = r16 + 1;     // Catch: Throwable -> L29
        if (r17 != 1) goto L19;
        startTrackingTable(r10, r16);     // Catch: Throwable -> L29
    L23:
        r15 = r15 + 1;     // Catch: Throwable -> L29
        r16 = r18;
        goto L15
    L19:
        if (r17 != 2) goto L23;
        stopTrackingTable(r10, r16);     // Catch: Throwable -> L29
        goto L23
    L24:
        r10.setTransactionSuccessful();     // Catch: Throwable -> L29
        r10.endTransaction();     // Catch: Throwable -> L32
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r12);     // Catch: Throwable -> L35
        r11.unlock();     // Catch: Throwable -> L38 Throwable -> L38
        return;
    L29:
        th = move-exception;
        r10.endTransaction();     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        r11.unlock();     // Catch: Throwable -> L38 Throwable -> L38
        throw th;     // Catch: Throwable -> L38 Throwable -> L38
    L38:
        e = move-exception;
        Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e);
    }
}
