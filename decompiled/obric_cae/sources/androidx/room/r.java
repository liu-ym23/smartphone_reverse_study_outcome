package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
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
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {
    public static final c Companion = null;
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean allowMainThreadQueries;
    private androidx.room.a autoCloser;
    private Map<Class<Object>, Object> autoMigrationSpecs;
    private final Map<String, Object> backingFieldMap;
    private a1.c internalOpenHelper;
    private Executor internalQueryExecutor;
    private Executor internalTransactionExecutor;
    private final i invalidationTracker;
    protected List<? extends b> mCallbacks;
    protected volatile a1.b mDatabase;
    private final ReentrantReadWriteLock readWriteLock;
    private final ThreadLocal<Integer> suspendingTransactionId;
    private final Map<Class<?>, Object> typeConverters;
    private boolean writeAheadLoggingEnabled;

    public static class a<T extends r> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f2663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<T> f2664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f2665c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ArrayList f2666d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ArrayList f2667e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ArrayList f2668f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Executor f2669g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Executor f2670h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public a1.c.InterfaceC0001c f2671i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f2672j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final d f2673k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f2674l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f2675m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final long f2676n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final e f2677o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final LinkedHashSet f2678p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public HashSet f2679q;

        public a(Context r8, Class<T> r10, String r11) {
            he.i.f(r8, "context");
            this.f2663a = r8;
            this.f2664b = r10;
            this.f2665c = r11;
            this.f2666d = new ArrayList();
            this.f2667e = new ArrayList();
            this.f2668f = new ArrayList();
            this.f2673k = d.f2680a;
            this.f2674l = true;
            this.f2676n = -1;
            this.f2677o = new e();
            this.f2678p = new LinkedHashSet();
        }

        public final void a(x0.a... r8) {
            if (this.f2679q != null) goto L5;
            this.f2679q = new HashSet();
        L5:
            int r10 = r8.length;
            int r11 = 0;
        L6:
            if (r11 >= r10) goto L8;
            x0.a r12 = r8[r11];
            HashSet r13 = this.f2679q;
            he.i.c(r13);
            r13.add(Integer.valueOf(r12.f13364a));
            HashSet r14 = this.f2679q;
            he.i.c(r14);
            r14.add(Integer.valueOf(r12.f13365b));
            r11 = r11 + 1;
            goto L6
        L8:
            x0.a[] r15 = (x0.a[]) Arrays.copyOf(r8, r8.length);
            this.f2677o.a(r15);
        }

        public final T b() {
            Executor r8 = this.f2669g;
            if (r8 == null) goto L5;
        L7:
            if (r8 != null) goto L9;
        L11:
            if (r8 != null) goto L14;
            Executor r10 = this.f2670h;
        L13:
            this.f2669g = r10;
        L14:
            HashSet r11 = this.f2679q;
            LinkedHashSet r14 = this.f2678p;
            if (r11 == null) goto L24;
            Iterator r12 = r11.iterator();
        L18:
            if (r12.hasNext() == false) goto L24;
            int r13 = ((Number) r12.next()).intValue();
            if ((!r14.contains(Integer.valueOf(r13))) == true) goto L18;
            throw new IllegalArgumentException(defpackage.a.d("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: ", r13).toString());
        L24:
            a1.c.InterfaceC0001c r15 = this.f2671i;
            if (r15 != null) goto L27;
            r15 = new b1.f();
        L27:
            a1.c.InterfaceC0001c r16 = r15;
            if (this.f2676n > 0) goto L30;
            String r17 = this.f2665c;
            e r18 = this.f2677o;
            ArrayList r19 = this.f2666d;
            boolean r20 = this.f2672j;
            d r21 = this.f2673k;
            r21.getClass();
            Context r110 = this.f2663a;
            he.i.f(r110, "context");
            if (r21 == d.f2680a) goto L38;
        L37:
            d r22 = r21;
            Executor r111 = this.f2669g;
            if (r111 == null) goto L78;
            Executor r112 = this.f2670h;
            if (r112 == null) goto L76;
            androidx.room.c r23 = new androidx.room.c(r110, r17, r16, r18, r19, r20, r22, r111, r112, this.f2674l, this.f2675m, r14, this.f2667e, this.f2668f);
            Class<T> r24 = this.f2664b;
            he.i.f(r24, "klass");
            Package r25 = r24.getPackage();
            he.i.c(r25);
            String r26 = r25.getName();
            String r27 = r24.getCanonicalName();
            he.i.c(r27);
            he.i.e(r26, "fullPackage");
            if (r26.length() != 0) goto L54;
            boolean r28 = true;
        L55:
            if (r28 == true) goto L58;
            r27 = r27.substring(r26.length() + 1);
            he.i.e(r27, "this as java.lang.String).substring(startIndex)");
        L58:
            String r29 = r27.replace('.', '_');
            he.i.e(r29, "this as java.lang.String…replace(oldChar, newChar)");
            String r30 = r29.concat("_Impl");
            if (r26.length() != 0) goto L62;
            boolean r31 = true;
        L63:
            if (r31 == false) goto L65;
            String r32 = r30;
        L66:
            Class<?> r33 = Class.forName(r32, true, r24.getClassLoader());     // Catch: InstantiationException -> L69 IllegalAccessException -> L71 ClassNotFoundException -> L73
            he.i.d(r33, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");     // Catch: InstantiationException -> L69 IllegalAccessException -> L71 ClassNotFoundException -> L73
            T r34 = (T) r33.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            r34.init(r23);
            return r34;
        L65:
            r32 = r26 + '.' + r30;     // Catch: InstantiationException -> L69 IllegalAccessException -> L71 ClassNotFoundException -> L73
            goto L66
        L62:
            r31 = false;
        L74:
            throw new RuntimeException("Cannot find implementation for " + r24.getCanonicalName() + ". " + r30 + " does not exist");
        L72:
            throw new RuntimeException("Cannot access the constructor " + r24.getCanonicalName());
        L70:
            throw new RuntimeException("Failed to create an instance of " + r24.getCanonicalName());
        L54:
            r28 = false;
            goto L55
        L76:
            throw new IllegalArgumentException("Required value was null.".toString());
        L78:
            throw new IllegalArgumentException("Required value was null.".toString());
        L38:
            Object r35 = r110.getSystemService("activity");
            if ((r35 instanceof ActivityManager) == false) goto L41;
            ActivityManager r36 = (ActivityManager) r35;
        L42:
            if (r36 != null) goto L44;
        L46:
            r21 = d.f2681b;
            goto L37
        L44:
            if (r36.isLowRamDevice() == true) goto L46;
            r21 = d.f2682m;
            goto L37
        L41:
            r36 = null;
            goto L42
        L30:
            if (this.f2665c == null) goto L34;
            throw new IllegalArgumentException("Required value was null.".toString());
        L34:
            throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.".toString());
        L9:
            if (this.f2670h != null) goto L11;
            this.f2670h = r8;
            goto L14
        L5:
            if (this.f2670h != null) goto L7;
            r10 = i.c.f8073e;
            this.f2670h = r10;
            goto L13
        }
    }

    public static abstract class b {
        public b() {
        }

        public void a(a1.b r8) {
            he.i.f(r8, "db");
        }
    }

    public static final class c {
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f2680a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f2681b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final d f2682m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final /* synthetic */ d[] f2683n = null;

        static {
            d r8 = new d("AUTOMATIC", 0);
            f2680a = r8;
            d r10 = new d("TRUNCATE", 1);
            f2681b = r10;
            d r11 = new d("WRITE_AHEAD_LOGGING", 2);
            f2682m = r11;
            f2683n = new d[]{r8, r10, r11};
        }

        public d(String r8, int r10) {
            super(r8, r10);
        }

        public static d valueOf(String r8) {
            return (d) Enum.valueOf(d.class, r8);
        }

        public static d[] values() {
            return (d[]) f2683n.clone();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedHashMap f2684a;

        public e() {
            this.f2684a = new LinkedHashMap();
        }

        public final void a(x0.a... r8) {
            he.i.f(r8, "migrations");
            int r10 = r8.length;
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L11;
            x0.a r12 = r8[r11];
            int r13 = r12.f13364a;
            LinkedHashMap r14 = this.f2684a;
            Integer r15 = Integer.valueOf(r13);
            Object r16 = r14.get(r15);
            if (r16 != null) goto L7;
            r16 = new TreeMap();
            r14.put(r15, r16);
        L7:
            TreeMap r17 = (TreeMap) r16;
            int r18 = r12.f13365b;
            if (r17.containsKey(Integer.valueOf(r18)) == false) goto L10;
            Log.w("ROOM", "Overriding migration " + r17.get(Integer.valueOf(r18)) + " with " + r12);
        L10:
            r17.put(Integer.valueOf(r18), r12);
            r11 = r11 + 1;
            goto L3
        }
    }

    static {
        Companion = new c();
    }

    public r() {
        this.invalidationTracker = createInvalidationTracker();
        this.autoMigrationSpecs = new LinkedHashMap();
        this.readWriteLock = new ReentrantReadWriteLock();
        this.suspendingTransactionId = new ThreadLocal();
        Map<String, Object> r8 = Collections.synchronizedMap(new LinkedHashMap());
        he.i.e(r8, "synchronizedMap(mutableMapOf())");
        this.backingFieldMap = r8;
        this.typeConverters = new LinkedHashMap();
    }

    public static final /* synthetic */ void access$internalBeginTransaction(r r8) {
        r8.internalBeginTransaction();
    }

    public static final /* synthetic */ void access$internalEndTransaction(r r8) {
        r8.internalEndTransaction();
    }

    public static /* synthetic */ void getMCallbacks$annotations() {
    }

    public static /* synthetic */ void getMDatabase$annotations() {
    }

    private final void internalBeginTransaction() {
        assertNotMainThread();
        a1.b r8 = getOpenHelper().Z();
        getInvalidationTracker().h(r8);
        if (r8.k0() == false) goto L5;
        r8.o();
        return;
    L5:
        r8.c();
    }

    private final void internalEndTransaction() {
        getOpenHelper().Z().t();
        if (inTransaction() == true) goto L8;
        i r8 = getInvalidationTracker();
        if (r8.f2628f.compareAndSet(false, true) == false) goto L9;
        r8.f2623a.getQueryExecutor().execute(r8.f2637o);
        return;
    L9:
        return;
    }

    public static /* synthetic */ void isOpen$annotations() {
    }

    public static /* synthetic */ void isOpenInternal$annotations() {
    }

    public static /* synthetic */ Cursor query$default(r r8, a1.e r10, CancellationSignal r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 2) == 0) goto L7;
        r11 = null;
    L7:
        return r8.query(r10, r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> T unwrapOpenHelper(Class<T> r8, a1.c r10) {
        if (r8.isInstance(r10) == false) goto L6;
        return r10;
    L6:
        if ((r10 instanceof androidx.room.d) == true) goto L10;
        return null;
    L10:
        return (T) unwrapOpenHelper(r8, ((androidx.room.d) r10).a());
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
        boolean r8 = true;
    L9:
        if (r8 == false) goto L12;
        return;
    L12:
        throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.".toString());
    L5:
        if (this.suspendingTransactionId.get() == null) goto L8;
        r8 = false;
        goto L9
    }

    public void beginTransaction() {
        assertNotMainThread();
        internalBeginTransaction();
    }

    public abstract void clearAllTables();

    public void close() {
        if (isOpen() == false) goto L10;
        ReentrantReadWriteLock.WriteLock r8 = this.readWriteLock.writeLock();
        he.i.e(r8, "readWriteLock.writeLock()");
        r8.lock();
        getInvalidationTracker().g();     // Catch: Throwable -> L7
        getOpenHelper().close();     // Catch: Throwable -> L7
        r8.unlock();
        return;
    L7:
        th = move-exception;
        r8.unlock();
        throw th;
    }

    public a1.f compileStatement(String r8) {
        he.i.f(r8, "sql");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().Z().S(r8);
    }

    public abstract i createInvalidationTracker();

    public abstract a1.c createOpenHelper(androidx.room.c r8);

    public void endTransaction() {
        internalEndTransaction();
    }

    public final Map<Class<Object>, Object> getAutoMigrationSpecs() {
        return this.autoMigrationSpecs;
    }

    public List<x0.a> getAutoMigrations(Map<Class<Object>, Object> r8) {
        he.i.f(r8, "autoMigrationSpecs");
        return yd.k.f14119a;
    }

    public final Map<String, Object> getBackingFieldMap() {
        return this.backingFieldMap;
    }

    public final Lock getCloseLock$room_runtime_release() {
        ReentrantReadWriteLock.ReadLock r8 = this.readWriteLock.readLock();
        he.i.e(r8, "readWriteLock.readLock()");
        return r8;
    }

    public i getInvalidationTracker() {
        return this.invalidationTracker;
    }

    public a1.c getOpenHelper() {
        a1.c r8 = this.internalOpenHelper;
        if (r8 == null) goto L5;
        return r8;
    L5:
        he.i.j("internalOpenHelper");
        throw null;
    }

    public Executor getQueryExecutor() {
        Executor r8 = this.internalQueryExecutor;
        if (r8 == null) goto L5;
        return r8;
    L5:
        he.i.j("internalQueryExecutor");
        throw null;
    }

    public Set<Class<Object>> getRequiredAutoMigrationSpecs() {
        return yd.m.f14121a;
    }

    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return yd.l.f14120a;
    }

    public final ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.suspendingTransactionId;
    }

    public Executor getTransactionExecutor() {
        Executor r8 = this.internalTransactionExecutor;
        if (r8 == null) goto L5;
        return r8;
    L5:
        he.i.j("internalTransactionExecutor");
        throw null;
    }

    public <T> T getTypeConverter(Class<T> r8) {
        he.i.f(r8, "klass");
        return (T) this.typeConverters.get(r8);
    }

    public boolean inTransaction() {
        return getOpenHelper().Z().j0();
    }

    public void init(androidx.room.c r13) {
        he.i.f(r13, "configuration");
        this.internalOpenHelper = createOpenHelper(r13);
        Set<Class<Object>> r8 = getRequiredAutoMigrationSpecs();
        BitSet r10 = new BitSet();
        Iterator<Class<Object>> r11 = r8.iterator();
    L3:
        boolean r12 = r11.hasNext();
        int r14 = -1;
        boolean r15 = true;
        List<Object> r16 = r13.f2617p;
        if (r12 == false) goto L20;
        Class<Object> r17 = r11.next();
        int r18 = r16.size() - 1;
        if (r18 < 0) goto L13;
    L7:
        int r19 = r18 - 1;
        if (r17.isAssignableFrom(r16.get(r18).getClass()) == true) goto L9;
        if (r19 < 0) goto L13;
        r18 = r19;
        goto L7
    L9:
        r10.set(r18);
        r14 = r18;
    L13:
        if (r14 >= 0) goto L16;
        r15 = false;
    L16:
        if (r15 == false) goto L19;
        this.autoMigrationSpecs.put(r17, r16.get(r14));
        goto L3
    L19:
        throw new IllegalArgumentException(("A required auto migration spec (" + r17.getCanonicalName() + ") is missing in the database configuration.").toString());
    L20:
        int r20 = r16.size() - 1;
        if (r20 < 0) goto L29;
    L22:
        int r21 = r20 - 1;
        if (r10.get(r20) == false) goto L28;
        if (r21 < 0) goto L29;
        r20 = r21;
        goto L22
    L28:
        throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.".toString());
    L29:
        Iterator<x0.a> r22 = getAutoMigrations(this.autoMigrationSpecs).iterator();
    L31:
        if (r22.hasNext() == false) goto L41;
        x0.a r23 = r22.next();
        int r24 = r23.f13364a;
        e r25 = r13.f2605d;
        LinkedHashMap r26 = r25.f2684a;
        if (r26.containsKey(Integer.valueOf(r24)) == false) goto L38;
        Map r27 = (Map) r26.get(Integer.valueOf(r24));
        if (r27 != null) goto L37;
        r27 = yd.l.f14120a;
    L37:
        boolean r28 = r27.containsKey(Integer.valueOf(r23.f13365b));
    L39:
        if (r28 == true) goto L31;
        r25.a(new x0.a[]{r23});
        goto L31
    L38:
        r28 = false;
        goto L39
    L41:
        w r29 = (w) unwrapOpenHelper(w.class, getOpenHelper());
        if (r29 == null) goto L45;
        r29.f2712a = r13;
    L45:
        if (((androidx.room.b) unwrapOpenHelper(androidx.room.b.class, getOpenHelper())) == null) goto L47;
        getInvalidationTracker().getClass();
        he.i.f(null, "autoCloser");
        throw null;
    L47:
        if (r13.f2608g != d.f2682m) goto L49;
        boolean r30 = true;
    L50:
        getOpenHelper().setWriteAheadLoggingEnabled(r30);
        this.mCallbacks = r13.f2606e;
        this.internalQueryExecutor = r13.f2609h;
        this.internalTransactionExecutor = new y(r13.f2610i);
        this.allowMainThreadQueries = r13.f2607f;
        this.writeAheadLoggingEnabled = r30;
        Intent r31 = r13.f2611j;
        if (r31 == null) goto L57;
        String r32 = r13.f2603b;
        if (r32 == null) goto L56;
        i r33 = getInvalidationTracker();
        r33.getClass();
        Context r34 = r13.f2602a;
        he.i.f(r34, "context");
        r33.f2634l = new MultiInstanceInvalidationClient(r34, r32, r31, r33, r33.f2623a.getQueryExecutor());
        goto L57
    L56:
        throw new IllegalArgumentException("Required value was null.".toString());
    L57:
        Map<Class<?>, List<Class<?>>> r35 = getRequiredTypeConverters();
        BitSet r36 = new BitSet();
        Iterator<Map.Entry<Class<?>, List<Class<?>>>> r37 = r35.entrySet().iterator();
    L58:
        boolean r38 = r37.hasNext();
        List<Object> r39 = r13.f2616o;
        if (r38 == false) goto L79;
        Map.Entry<Class<?>, List<Class<?>>> r40 = r37.next();
        Class<?> r41 = r40.getKey();
        Iterator<Class<?>> r42 = r40.getValue().iterator();
    L62:
        if (r42.hasNext() == false) goto L58;
        Class<?> r43 = r42.next();
        int r44 = r39.size() - 1;
        if (r44 < 0) goto L71;
    L65:
        int r110 = r44 - 1;
        if (r43.isAssignableFrom(r39.get(r44).getClass()) == true) goto L67;
        if (r110 < 0) goto L71;
        r44 = r110;
        goto L65
    L67:
        r36.set(r44);
    L72:
        if (r44 < 0) goto L74;
        boolean r111 = true;
    L75:
        if (r111 == false) goto L78;
        this.typeConverters.put(r43, r39.get(r44));
        goto L62
    L78:
        throw new IllegalArgumentException(("A required type converter (" + r43 + ") for " + r41.getCanonicalName() + " is missing in the database configuration.").toString());
    L74:
        r111 = false;
    L71:
        r44 = -1;
        goto L72
    L79:
        int r112 = r39.size() - 1;
        if (r112 < 0) goto L88;
    L81:
        int r113 = r112 - 1;
        if (r36.get(r112) == false) goto L87;
        if (r113 < 0) goto L109;
        r112 = r113;
        goto L81
    L109:
        return;
    L87:
        throw new IllegalArgumentException("Unexpected type converter " + r39.get(r112) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
    L88:
        return;
    L49:
        r30 = false;
        goto L50
    }

    public void internalInitInvalidationTracker(a1.b r8) {
        he.i.f(r8, "db");
        i r10 = getInvalidationTracker();
        r10.getClass();
        Object r11 = r10.f2636n;
        monitor-enter(r11);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r10.f2629g == false) goto L9;
        Log.e("ROOM", "Invalidation tracker is initialized twice :/.");     // Catch: Throwable -> L12
    L7:
        monitor-exit(r11);
        return;
    L9:
        r8.e("PRAGMA temp_store = MEMORY;");     // Catch: Throwable -> L12
        r8.e("PRAGMA recursive_triggers='ON';");     // Catch: Throwable -> L12
        r8.e("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");     // Catch: Throwable -> L12
        r10.h(r8);     // Catch: Throwable -> L12
        r10.f2630h = r8.S("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");     // Catch: Throwable -> L12
        r10.f2629g = true;     // Catch: Throwable -> L12
        xd.j r12 = xd.j.f13877a;     // Catch: Throwable -> L12
        goto L7
    }

    public final boolean isMainThread$room_runtime_release() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isOpen() {
        androidx.room.a r8 = this.autoCloser;
        if (r8 == null) goto L5;
        r8.getClass();
        boolean r10 = !false;
    L8:
        Boolean r11 = Boolean.valueOf(r10);
    L11:
        return he.i.a(r11, Boolean.TRUE);
    L5:
        a1.b r12 = this.mDatabase;
        if (r12 == null) goto L9;
        r10 = r12.isOpen();
        goto L8
    L9:
        r11 = null;
        goto L11
    }

    public final boolean isOpenInternal() {
        a1.b r8 = this.mDatabase;
        if (r8 != null) goto L5;
        return false;
    L5:
        if (r8.isOpen() == true) goto L7;
        return false;
    L7:
        return true;
    }

    public final Cursor query(a1.e r8) {
        he.i.f(r8, "query");
        return query$default(this, r8, null, 2, null);
    }

    public <V> V runInTransaction(Callable<V> r8) {
        he.i.f(r8, "body");
        beginTransaction();
        V r10 = r8.call();     // Catch: Throwable -> L6
        setTransactionSuccessful();     // Catch: Throwable -> L6
        endTransaction();
        return r10;
    L6:
        th = move-exception;
        endTransaction();
        throw th;
    }

    public final void setAutoMigrationSpecs(Map<Class<Object>, Object> r8) {
        he.i.f(r8, "<set-?>");
        this.autoMigrationSpecs = r8;
    }

    public void setTransactionSuccessful() {
        getOpenHelper().Z().m();
    }

    public Cursor query(a1.e r8, CancellationSignal r10) {
        he.i.f(r8, "query");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        a1.b r11 = getOpenHelper().Z();
        if (r10 == null) goto L6;
        return r11.M(r8, r10);
    L6:
        return r11.q(r8);
    }

    public void runInTransaction(Runnable r8) {
        he.i.f(r8, "body");
        beginTransaction();
        r8.run();     // Catch: Throwable -> L6
        setTransactionSuccessful();     // Catch: Throwable -> L6
        endTransaction();
        return;
    L6:
        th = move-exception;
        endTransaction();
        throw th;
    }

    public Cursor query(String r8, Object[] r10) {
        he.i.f(r8, "query");
        return getOpenHelper().Z().q(new a1.a(r8, r10));
    }
}
