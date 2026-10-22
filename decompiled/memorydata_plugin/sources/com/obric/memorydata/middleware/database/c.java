package com.obric.memorydata.middleware.database;

import android.content.Context;
import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001%B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\rJ\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\nJ$\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0005J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0012\u001a\u00020\u0005J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0017\u001a\u00020\u0005J\u001a\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/memorydata/middleware/database/DatabaseManager;", "", "<init>", "()V", "TAG", "", "dbInstanceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/middleware/database/DatabaseManager$DbEntry;", "dbSchemaMap", "Lcom/obric/memorydata/middleware/database/SqlDatabaseSchema;", "dbLockMap", "refreshRoomInvalidationMap", "Lkotlin/Function0;", "", "dbOpenerMap", "", "registerRoomDbOpener", "logicName", "opener", "initDatabase", "dbSchema", "registerDatabase", "dbName", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "refresh", "invokeRefreshRoomInvalidation", "getAdaptedDatabase", "getDatabase", "shouldReturnExistingDb", "dbEntry", "openDatabase", "restoreDatabase", "hasLocalDatabase", "readDatabaseVersion", "", "DbEntry", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f11648a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f11649b = null;
    private static final ConcurrentHashMap<String, k> c = null;
    private static final ConcurrentHashMap<String, Object> d = null;
    private static final ConcurrentHashMap<String, Function0<Boolean>> e = null;
    private static final ConcurrentHashMap<String, Function0<Unit>> f = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/middleware/database/DatabaseManager$DbEntry;", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "version", "", "<init>", "(Landroidx/sqlite/db/SupportSQLiteDatabase;I)V", "getDb", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "getVersion", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SupportSQLiteDatabase f11650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f11651b;

        public a(SupportSQLiteDatabase r3, int r4) {
            SupportSQLiteDatabase r5 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "db");
            this.f11650a = r5;
            this.f11651b = r4;
        }

        public final SupportSQLiteDatabase a() {
            return this.f11650a;
        }

        public final int b() {
            return this.f11651b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11650a, r6.f11650a) == true) goto L12;
            return false;
        L12:
            if (this.f11651b == r6.f11651b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f11650a.hashCode() * 31) + Integer.hashCode(this.f11651b);
        }

        public String toString() {
            return "DbEntry(db=" + this.f11650a + ", version=" + this.f11651b + ')';
        }
    }

    static {
        f11648a = new c();
        f11649b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
    }

    private c() {
    }

    private final int a(SupportSQLiteDatabase r2) {
        Cursor r1 = ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).query("PRAGMA user_version;");
        int r0 = 0;
        if (r1.moveToFirst() == false) goto L6;
        r0 = r1.getInt(0);     // Catch: Throwable -> L8
    L6:
        r1.close();
        return r0;
    L8:
        th = move-exception;
        r1.close();
        throw th;
    }

    private static final Object a(Function1 r2, Object r3) {
        return ((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3);
    }

    private final boolean a(String r3, a r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        k r5 = (k) ZeusTransformUtils.preCheckCast(c.get(r3), k.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L9;
        return true;
    L9:
        if (r4.b() >= r5.a()) goto L11;
        return false;
    L11:
        return true;
    }

    private final a b(k r11) {
        RunLog.INSTANCE.debug("db_iso_DatabaseManager", "Initializing database " + r11.d());
        a r0 = (a) ZeusTransformUtils.preCheckCast(f11649b.get(r11.d()), a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L7:
        SQLiteDatabase r1 = d.f11652a.b(r11.d());
        if (r1 != null) goto L11;
        c r10 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_DatabaseManager", "Failed to open encrypted database " + r11.d() + ": sdk returned null", null, 4, null);
        return null;
    L11:
        int r12 = a((SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(r1, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug("db_iso_DatabaseManager", "Current version of " + r11.d() + ": " + r12);
        if (r12 != 0) goto L28;
        RunLog.INSTANCE.debug("db_iso_DatabaseManager", "Creating new database " + r11.d());
        r1.beginTransaction();
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L20 Exception -> L22
    L16:
        if (r5.hasNext() == false) goto L18;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20 Exception -> L22
        RunLog.INSTANCE.debug("db_iso_DatabaseManager", "Executing: " + r6);     // Catch: Throwable -> L20 Exception -> L22
        r1.execSQL(r6);     // Catch: Throwable -> L20 Exception -> L22
        goto L16
    L18:
        r1.execSQL("PRAGMA user_version = " + r11.a());     // Catch: Throwable -> L20 Exception -> L22
        r1.setTransactionSuccessful();     // Catch: Throwable -> L20 Exception -> L22
    L41:
        r1.endTransaction();
    L50:
        return new a((SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(r1, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"), Math.max(r12, r11.a()));
    L20:
        th = move-exception;
        r1.endTransaction();
        throw th;
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
        throw new DatabaseException(r11.d(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L20
    L28:
        if (r12 >= r11.a()) goto L50;
        RunLog.INSTANCE.debug("db_iso_DatabaseManager", "Upgrading database " + r11.d() + " from " + r12 + " to " + r11.a());
        r1.beginTransaction();
        int r7 = r12;
    L51:
    L42:
        th = move-exception;
        r1.endTransaction();
        throw th;
    L44:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L42
        throw new DatabaseException(r11.d(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L42
    L31:
        if (r7 >= r11.a()) goto L40;
        StringBuilder r8 = new StringBuilder().append(r7).append('_');     // Catch: Throwable -> L42 Exception -> L44
        r7 = r7 + 1;     // Catch: Throwable -> L42 Exception -> L44
        String r9 = r8.append(r7).toString();     // Catch: Throwable -> L42 Exception -> L44
        List r13 = (List) ZeusTransformUtils.preCheckCast(r11.c().get(r9), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42 Exception -> L44
        if (r13 == null) goto L39;
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L42 Exception -> L44
    L36:
        if (r14.hasNext() == false) goto L51;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42 Exception -> L44
        RunLog.INSTANCE.debug("db_iso_DatabaseManager", "Executing: " + r15);     // Catch: Throwable -> L42 Exception -> L44
        r1.execSQL(r15);     // Catch: Throwable -> L42 Exception -> L44
        goto L36
    L39:
        throw new IllegalStateException("Missing upgrade path: " + r9);     // Catch: Throwable -> L42 Exception -> L44
    L40:
        r1.execSQL("PRAGMA user_version = " + r11.a());     // Catch: Throwable -> L42 Exception -> L44
        r1.setTransactionSuccessful();     // Catch: Throwable -> L42 Exception -> L44
        goto L41
    L5:
        if (r0.b() < r11.a()) goto L7;
        return r0;
    }

    private final a d(String r9) {
        if (e(r9) == true) goto L5;
        return null;
    L5:
        RunLog.INSTANCE.debug("db_iso_DatabaseManager", "Restoring database " + r9 + " from local file");
        SQLiteDatabase r0 = d.f11652a.b(r9);
        if (r0 != null) goto L9;
        c r8 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_DatabaseManager", "Failed to restore encrypted database " + r9 + ": sdk returned null", null, 4, null);
        return null;
    L9:
        int r10 = a((SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(r0, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug("db_iso_DatabaseManager", "Restored database " + r9 + ", version " + r10);
        return new a((SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(r0, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"), r10);
    }

    private final boolean e(String r3) {
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getDatabasePath(r3).exists();
    }

    private static final Object f(String r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return new Object();
    }

    public static /* synthetic */ Object lambda$A6ANo_D1OMxY_2CBXdibVoE_QJ4(Function1 r0, Object r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Object lambda$Xoxw2VoZawZCOU9AnOAKm_96xZI(String r0) {
        return f(r0);
    }

    public final void a(k r8) {
        Intrinsics.checkNotNullParameter(r8, "dbSchema");
        ((Map) ZeusTransformUtils.preCheckCast(c, Map.class, "com.obric.memorydata.plugin")).put(r8.d(), r8);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_DatabaseManager", "initDatabase " + r8.d() + ", version: " + r8.a(), false, 4, null);
        c(r8.d());
    }

    public final void a(String r5, SupportSQLiteDatabase r6, Function0<Boolean> r7) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r6, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "dbName");
        Intrinsics.checkNotNullParameter(r4, "db");
        Intrinsics.checkNotNullParameter(r8, "refresh");
        ConcurrentHashMap<String, a> r9 = f11649b;
        monitor-enter(r9);
        RunLog.INSTANCE.debug("db_iso_DatabaseManager", "Registering database " + r5 + ", version " + r4.getVersion());     // Catch: Throwable -> L10
        if (((a) ZeusTransformUtils.preCheckCast(r9.get(r5), a.class, "com.obric.memorydata.plugin")) != null) goto L7;
        ((Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.memorydata.plugin")).put(r5, new a(r4, r4.getVersion()));     // Catch: Throwable -> L10
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L7:
        monitor-exit(r9);
        ((Map) ZeusTransformUtils.preCheckCast(e, Map.class, "com.obric.memorydata.plugin")).put(r5, r8);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void a(String r7, Function0<Unit> r8) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "logicName");
        Intrinsics.checkNotNullParameter(r6, "opener");
        ((Map) ZeusTransformUtils.preCheckCast(f, Map.class, "com.obric.memorydata.plugin")).put(r7, r6);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_DatabaseManager", "registerRoomDbOpener " + r7, false, 4, null);
    }

    public final boolean a(String r7) {
        Intrinsics.checkNotNullParameter(r7, "dbName");
        Function0 r6 = (Function0) ZeusTransformUtils.preCheckCast(e.get(r7), Function0.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_DatabaseManager", "refreshRoomInvalidation is not been registered for " + r7, false, 4, null);
        return false;
    L7:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r6.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final SupportSQLiteDatabase b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "logicName");
        String r0 = b.f11646a.b(r10);
        SupportSQLiteDatabase r1 = c(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        Function0 r2 = (Function0) ZeusTransformUtils.preCheckCast(f.get(r10), Function0.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L9;
        return null;
    L9:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_DatabaseManager", "trigger room db opener for " + r10 + " on missing " + r0, false, 4, null);
        r2.invoke();
        return c(b.f11646a.b(r10));
    }

    public final SupportSQLiteDatabase c(String r7) {
        Intrinsics.checkNotNullParameter(r7, "dbName");
        ConcurrentHashMap<String, a> r6 = f11649b;
        monitor-enter(r6);
        a r0 = (a) ZeusTransformUtils.preCheckCast(r6.get(r7), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        c r1 = f11648a;     // Catch: Throwable -> L51
        SupportSQLiteDatabase r3 = null;
        if (r1.a(r7, r0) == false) goto L10;
        if (r0 == null) goto L8;
        r3 = r0.a();     // Catch: Throwable -> L51
    L8:
        monitor-exit(r6);
        return r3;
    L10:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L51
        monitor-exit(r6);
        ConcurrentHashMap<String, Object> r4 = d;
        final $$Lambda$c$Xoxw2VoZawZCOU9AnOAKm_96xZI r5 = $$Lambda$c$Xoxw2VoZawZCOU9AnOAKm_96xZI.INSTANCE;
        Object r8 = r4.computeIfAbsent(r7, new $$Lambda$c$A6ANo_D1OMxY_2CBXdibVoE_QJ4(r5));
        Intrinsics.checkNotNullExpressionValue(r8, "computeIfAbsent(...)");
        monitor-enter(r8);
        monitor-enter(r6);     // Catch: Throwable -> L48
        a r9 = (a) ZeusTransformUtils.preCheckCast(r6.get(r7), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        if (r1.a(r7, r9) == false) goto L22;
        if (r9 == null) goto L19;
        r3 = r9.a();     // Catch: Throwable -> L45
    L19:
        monitor-exit(r6);     // Catch: Throwable -> L48
        monitor-exit(r8);
        return r3;
    L22:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L45
        monitor-exit(r6);     // Catch: Throwable -> L48
        k r11 = (k) ZeusTransformUtils.preCheckCast(c.get(r7), k.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
        if (r11 == null) goto L27;
    L30:
        if (r11 == null) goto L32;
        a r12 = r1.b(r11);     // Catch: Throwable -> L48
    L33:
        if (r12 != null) goto L36;
        monitor-exit(r8);
        return null;
    L36:
        monitor-enter(r6);     // Catch: Throwable -> L48
        ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).put(r7, r12);     // Catch: Throwable -> L42
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L42
        monitor-exit(r6);     // Catch: Throwable -> L48
        SupportSQLiteDatabase r14 = r12.a();     // Catch: Throwable -> L48
        monitor-exit(r8);
        return r14;
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L48
    L32:
        r12 = r1.d(r7);     // Catch: Throwable -> L48
        goto L33
    L27:
        if (r1.e(r7) == true) goto L30;
        monitor-exit(r8);
        return null;
    L45:
        th = move-exception;
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    L51:
        th = move-exception;
        throw th;
    }
}
