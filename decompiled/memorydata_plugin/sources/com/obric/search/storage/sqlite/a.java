package com.obric.search.storage.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.search.api.a.c;
import com.obric.search.api.c.e;
import com.obric.search.common.log.RuntimeLogger;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.m;
import com.tencent.wcdb.database.o;
import com.tencent.wcdb.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 22\u00020\u0001:\u00012B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J0\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\tJ6\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u001e\u0010\u001c\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\u00180\tJ\"\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005J\u0016\u0010!\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J \u0010(\u001a\b\u0012\u0004\u0012\u00020\u001d0\t2\u0006\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u0005H\u0007J(\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00050\u00180\t2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J6\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020+0\u00180\t2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050\tJJ\u0010-\u001a\u00020.2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010/\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u000101R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/search/storage/sqlite/SQLiteSearchEngine;", "", "context", "Landroid/content/Context;", "databaseName", "", "version", "", "schemaList", "", "Lcom/obric/search/storage/sqlite/schema/intf/ISQLiteTableSchema;", "passPhrase", "sqlCipherConfig", "Lcom/obric/search/api/config/SQLCipherConfig;", "migrationContainer", "Lcom/obric/search/api/migration/MigrationContainer;", "databasePath", "(Landroid/content/Context;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Lcom/obric/search/api/config/SQLCipherConfig;Lcom/obric/search/api/migration/MigrationContainer;Ljava/lang/String;)V", "sqliteDatabaseManager", "Lcom/obric/search/storage/sqlite/manager/SQLiteDatabaseManager;", "statementMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/wcdb/database/SQLiteStatement;", "batchDeleteByLongValue", "Lkotlin/Pair;", "", "tableName", "deleteSQL", "arguments", "", "batchInsertStringValue", "insertSQL", "executeDelete", "executeInsert", "getCachedStatement", "sqlString", "getCursor", "Lcom/tencent/wcdb/Cursor;", "querySQL", "matchClause", "queryRowId", "queryRowIdAndAuxiliaryFuncStringResult", "queryRowIdAndStringColumn", "Landroid/content/ContentValues;", "columnList", "recreateSqliteDatabaseManager", "", "setSQLiteDatabaseTraceCallback", "sqliteTrace", "Lcom/obric/search/api/config/SQLiteTrace;", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0798a f14961a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.search.storage.sqlite.manager.a f14962b;
    private final ConcurrentHashMap<String, m> c;

    /* JADX INFO: renamed from: com.obric.search.storage.sqlite.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/search/storage/sqlite/SQLiteSearchEngine$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0798a {
        private C0798a() {
        }

        public /* synthetic */ C0798a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000I\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J^\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000b2\u0014\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0011\u0018\u00010\u00102\u001a\u0010\u0012\u001a\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0011\u0018\u00010\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J,\u0010\u0016\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0016¨\u0006\u001a"}, d2 = {"com/obric/search/storage/sqlite/SQLiteSearchEngine$setSQLiteDatabaseTraceCallback$1", "Lcom/tencent/wcdb/database/SQLiteTrace;", "onConnectionObtained", "", "db", "Lcom/tencent/wcdb/database/SQLiteDatabase;", "sql", "", "waitTime", "", "isPrimary", "", "onConnectionPoolBusy", "sqlWaiting", "wantPrimaryConnection", "sqlRunning", "", "Lcom/tencent/wcdb/database/SQLiteTrace$TraceInfo;", "longLastingActions", "", "Ljava/lang/StackTraceElement;", "onDatabaseCorrupted", "onSQLExecuted", "type", "", OaidModel.KEY_TIME, "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f14963a;

        b(c r3) {
            this.f14963a = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        }

        @Override // com.tencent.wcdb.database.o
        public void a(SQLiteDatabase r1) {
            this.f14963a.a();
        }

        @Override // com.tencent.wcdb.database.o
        public void a(SQLiteDatabase r1, String r2, int r3, long r4) {
            this.f14963a.a(r2, r3, r4);
        }

        @Override // com.tencent.wcdb.database.o
        public void a(SQLiteDatabase r1, String r2, long r3, boolean r5) {
            this.f14963a.a(r2, r3, r5);
        }

        @Override // com.tencent.wcdb.database.o
        public void a(SQLiteDatabase r14, String r15, long r16, boolean r18, List<o.a<String>> r19, List<o.a<StackTraceElement[]>> r20) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
            List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
            c r3 = this.f14963a;
            if (r0 == null) goto L9;
            Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r4 = r1.iterator();
        L6:
            if (r4.hasNext() == false) goto L8;
            o.a r8 = (o.a) ZeusTransformUtils.preCheckCast(r4.next(), o.a.class, "com.obric.memorydata.plugin");
            T r10 = r8.f15867a;
            Intrinsics.checkNotNullExpressionValue(r10, "it.info");
            r7.add(new c.b(r10, r8.f15868b, r8.c));
            goto L6
        L8:
            List<c.b<String>> r9 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        L10:
            if (r2 == null) goto L16;
            Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
            Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r11 = r5.iterator();
        L13:
            if (r11.hasNext() == false) goto L15;
            o.a r12 = (o.a) ZeusTransformUtils.preCheckCast(r11.next(), o.a.class, "com.obric.memorydata.plugin");
            T r13 = r12.f15867a;
            Intrinsics.checkNotNullExpressionValue(r13, "it.info");
            r6.add(new c.b(r13, r12.f15868b, r12.c));
            goto L13
        L15:
            List<c.b<StackTraceElement[]>> r17 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        L17:
            r3.a(r15, r16, r18, r9, r17);
            return;
        L16:
            r17 = null;
            goto L17
        L9:
            r9 = null;
            goto L10
        }
    }

    static {
        f14961a = new C0798a(null);
    }

    public a(Context r13, String r14, int r15, List<? extends com.obric.search.storage.sqlite.a.b.a> r16, String r17, com.obric.search.api.a.b r18, e r19, String r20) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r14, "databaseName");
        Intrinsics.checkNotNullParameter(r7, "schemaList");
        this.f14962b = new com.obric.search.storage.sqlite.manager.a(r4, r14, r15, r7, r17, r18, r19, r20);
        this.c = new ConcurrentHashMap();
    }

    private final m a(String r4) {
        m r0 = (m) ZeusTransformUtils.preCheckCast(this.c.get(r4), m.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        m r1 = this.f14962b.a().b(r4);
        this.c.put(r4, r1);
        Intrinsics.checkNotNullExpressionValue(r1, "{\n            val newSta…   newStatement\n        }");
        return r1;
    L7:
        return r0;
    }

    public final synchronized void a(Context r14, String r15, int r16, List<? extends com.obric.search.storage.sqlite.a.b.a> r17, String r18, com.obric.search.api.a.b r19, e r20) {
        monitor-enter(this);
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r3, "context");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r15, "databaseName");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r6, "schemaList");     // Catch: Throwable -> L7
        this.c.clear();     // Catch: Throwable -> L7
        this.f14962b = new com.obric.search.storage.sqlite.manager.a(r3, r15, r16, r6, r18, r19, r20, null, 128, null);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(c r4) {
        monitor-enter(this);
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r5 != null) goto L8;
        this.f14962b.a().a(null);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L8:
        this.f14962b.a().a((o) ZeusTransformUtils.preCheckCast(new b(r5), o.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean a(String r6, String r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "tableName");     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r7, "insertSQL");     // Catch: Throwable -> L17
        m r8 = a(r7);     // Catch: Throwable -> L17
        this.f14962b.a().e();     // Catch: Throwable -> L17
        boolean r9 = false;
        long r1 = r8.j();     // Catch: Exception -> L11 Throwable -> L17
        if (r1 != (-1)) goto L8;
        RuntimeLogger.f14958a.d("SQLiteSearchEngine", "executeInsert error! Statement.executeInsert return " + r1 + '.');     // Catch: Exception -> L11 Throwable -> L17
        r9 = true;
    L8:
        if (r9 == true) goto L13;
        this.f14962b.a().g();     // Catch: Exception -> L11 Throwable -> L17
    L13:
        this.f14962b.a().f();     // Catch: Throwable -> L17
        boolean r10 = !r9;
        monitor-exit(this);
        return r10;
    L11:
        e = move-exception;
        RuntimeLogger.f14958a.d("SQLiteSearchEngine", "executeInsert error!\n" + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L17
        r9 = true;
    L17:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean a(String r8, String r9, List<? extends Pair<Long, ? extends List<String>>> r10) {
        monitor-enter(this);
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r8, "tableName");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r9, "insertSQL");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r11, "arguments");     // Catch: Throwable -> L24
        m r12 = a(r9);     // Catch: Throwable -> L24
        this.f14962b.a().e();     // Catch: Throwable -> L24
        boolean r13 = false;
        Iterator r14 = r11.iterator();     // Catch: Exception -> L18 Throwable -> L24
    L7:
        if (r14.hasNext() == false) goto L15;
        Pair r1 = (Pair) ZeusTransformUtils.preCheckCast(r14.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L18 Throwable -> L24
        r12.a(1, ((Number) ZeusTransformUtils.preCheckCast(r1.getFirst(), Number.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Exception -> L18 Throwable -> L24
        int r2 = 2;
        Iterator r3 = ((List) ZeusTransformUtils.preCheckCast(r1.getSecond(), List.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L18 Throwable -> L24
    L10:
        if (r3.hasNext() == false) goto L12;
        r12.a(r2, (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L18 Throwable -> L24
        r2 = r2 + 1;     // Catch: Exception -> L18 Throwable -> L24
        goto L10
    L12:
        long r4 = r12.j();     // Catch: Exception -> L18 Throwable -> L24
        if (r4 != (-1)) goto L7;
        RuntimeLogger.f14958a.d("SQLiteSearchEngine", "batchInsertStringValue error! executeInsert return " + r4 + ". (RowID is " + ((Number) ZeusTransformUtils.preCheckCast(r1.getFirst(), Number.class, "com.obric.memorydata.plugin")).longValue() + ')');     // Catch: Exception -> L18 Throwable -> L24
        r13 = true;
    L15:
        if (r13 == true) goto L20;
        this.f14962b.a().g();     // Catch: Exception -> L18 Throwable -> L24
    L20:
        this.f14962b.a().f();     // Catch: Throwable -> L24
        boolean r15 = !r13;
        monitor-exit(this);
        return r15;
    L18:
        e = move-exception;
        RuntimeLogger.f14958a.d("SQLiteSearchEngine", "batchInsertStringValue error!\n" + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L24
        r13 = true;
    L24:
        th = move-exception;
        throw th;
    }

    public final synchronized List<Long> b(String r8, String r9) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r8, "querySQL");     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r9, "matchClause");     // Catch: Throwable -> L25
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        String[] r10 = (String[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(new String[0], Object[].class, "com.obric.memorydata.plugin"), String[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
    L10:
        List<Long> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(this.f14962b.a().a(r8, r10), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        f r2 = (f) ZeusTransformUtils.preCheckCast(r11, f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        RuntimeLogger.f14958a.a("SQLiteSearchEngine", "queryRowId cursor size is " + r2.getCount());     // Catch: Throwable -> L20
    L14:
        if (r2.moveToNext() == false) goto L16;
        r1.add(Long.valueOf(r2.getLong(0)));     // Catch: Throwable -> L20
        goto L14
    L16:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r11, null);     // Catch: Throwable -> L25
        monitor-exit(this);
        return r1;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L9:
        r10 = new String[]{r9};     // Catch: Throwable -> L25
        goto L10
    L6:
        r0 = false;
    L25:
        th = move-exception;
        throw th;
    }

    public final synchronized List<Pair<Long, ContentValues>> b(String r10, String r11, List<String> r12) {
        monitor-enter(this);
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        Intrinsics.checkNotNullParameter(r10, "querySQL");     // Catch: Throwable -> L47
        Intrinsics.checkNotNullParameter(r11, "matchClause");     // Catch: Throwable -> L47
        Intrinsics.checkNotNullParameter(r13, "columnList");     // Catch: Throwable -> L47
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        String[] r14 = (String[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(new String[0], Object[].class, "com.obric.memorydata.plugin"), String[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
    L10:
        List<Pair<Long, ContentValues>> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        Closeable r15 = (Closeable) ZeusTransformUtils.preCheckCast(this.f14962b.a().a(r10, r14), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        f r16 = (f) ZeusTransformUtils.preCheckCast(r15, f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        RuntimeLogger.f14958a.a("SQLiteSearchEngine", "queryRowIdAndStringColumn cursor size is " + r16.getCount());     // Catch: Throwable -> L42
        int r2 = r16.getColumnIndex("rowid");     // Catch: Throwable -> L42
        if (r2 != (-1)) goto L17;
        RuntimeLogger.f14958a.d("SQLiteSearchEngine", "queryRowIdAndStringColumn ROWID index is -1");     // Catch: Throwable -> L42
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L47
        monitor-exit(this);
        return r1;
    L17:
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        Iterator r17 = r13.iterator();     // Catch: Throwable -> L42
    L19:
        if (r17.hasNext() == false) goto L28;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        int r6 = r16.getColumnIndex(r5);     // Catch: Throwable -> L42
        if (r6 == (-1)) goto L22;
        r4.put(r5, Integer.valueOf(r6));     // Catch: Throwable -> L42
        goto L19
    L22:
        RuntimeLogger.f14958a.d("SQLiteSearchEngine", "queryRowIdAndStringColumn " + r5 + " index is -1");     // Catch: Throwable -> L42
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L47
        monitor-exit(this);
        return r1;
    L28:
        if (r16.moveToNext() == false) goto L38;
        ContentValues r18 = new ContentValues();     // Catch: Throwable -> L42
        Iterator r3 = r4.entrySet().iterator();     // Catch: Throwable -> L42
    L31:
        if (r3.hasNext() == false) goto L37;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        int r9 = ((Number) ZeusTransformUtils.preCheckCast(r7.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L42
        Intrinsics.checkNotNullExpressionValue(r16, "it");     // Catch: Throwable -> L42
        Cursor r19 = (Cursor) ZeusTransformUtils.preCheckCast(r16, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        if (r19.isNull(r9) == false) goto L35;
        String r20 = null;
    L36:
        r18.put(r8, r20);     // Catch: Throwable -> L42
        goto L31
    L35:
        r20 = r19.getString(r9);     // Catch: Throwable -> L42
        goto L36
    L37:
        r1.add(new Pair(Long.valueOf(r16.getLong(r2)), r18));     // Catch: Throwable -> L42
        goto L28
    L38:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L42
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L47
        monitor-exit(this);
        return r1;
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L9:
        r14 = new String[]{r11};     // Catch: Throwable -> L47
        goto L10
    L6:
        r0 = false;
    L47:
        th = move-exception;
        throw th;
    }

    public final synchronized List<Pair<Long, String>> c(String r8, String r9) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r8, "querySQL");     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r9, "matchClause");     // Catch: Throwable -> L18
        List<Pair<Long, String>> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        SQLiteDatabase r1 = this.f14962b.a();     // Catch: Throwable -> L18
        Object[] r10 = ((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(r9), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L18
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(r1.a(r8, r10), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        f r2 = (f) ZeusTransformUtils.preCheckCast(r11, f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        RuntimeLogger.f14958a.a("SQLiteSearchEngine", "queryRowId cursor size is " + r2.getCount());     // Catch: Throwable -> L13
    L7:
        if (r2.moveToNext() == false) goto L9;
        r0.add(new Pair(Long.valueOf(r2.getLong(0)), r2.getString(1)));     // Catch: Throwable -> L13
        goto L7
    L9:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r11, null);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r0;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public final synchronized Pair<Boolean, Integer> c(String r7, String r8, List<Long> r9) {
        monitor-enter(this);
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r7, "tableName");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r8, "deleteSQL");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r10, "arguments");     // Catch: Throwable -> L24
        m r11 = a(r8);     // Catch: Throwable -> L24
        this.f14962b.a().e();     // Catch: Throwable -> L24
        boolean r12 = true;
        Iterator r13 = r10.iterator();     // Catch: Exception -> L14 Throwable -> L24
        int r1 = 0;
    L31:
    L12:
        e = e;
    L16:
        RuntimeLogger.f14958a.d("SQLiteSearchEngine", "batchInsertStringValue error!\n" + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L24
        boolean r14 = true;
    L17:
        this.f14962b.a().f();     // Catch: Throwable -> L24
        if (r14 == false) goto L21;
        r12 = false;
    L21:
        Pair<Boolean, Integer> r15 = new Pair(Boolean.valueOf(r12), Integer.valueOf(r1));     // Catch: Throwable -> L24
        monitor-exit(this);
        return r15;
    L8:
        if (r13.hasNext() == false) goto L10;
        r11.a(1, ((Number) ZeusTransformUtils.preCheckCast(r13.next(), Number.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Exception -> L12 Throwable -> L24
        r1 = r1 + r11.i();     // Catch: Exception -> L12 Throwable -> L24
        goto L31
    L10:
        this.f14962b.a().g();     // Catch: Exception -> L12 Throwable -> L24
        r14 = false;
    L14:
        e = e;
        r1 = 0;
    L24:
        th = move-exception;
        throw th;
    }

    public final synchronized f d(String r4, String r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "querySQL");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r5, "matchClause");     // Catch: Throwable -> L6
        SQLiteDatabase r0 = this.f14962b.a();     // Catch: Throwable -> L6
        Object[] r6 = ((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(r5), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L6
        f r7 = r0.a(r4, r6);     // Catch: Throwable -> L6
        Intrinsics.checkNotNullExpressionValue(r7, "sqliteDatabaseManager.da…chClause).toTypedArray())");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r7;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Pair<Boolean, Integer> e(String r8, String r9) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r8, "tableName");     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r9, "deleteSQL");     // Catch: Throwable -> L21
        m r10 = a(r9);     // Catch: Throwable -> L21
        this.f14962b.a().e();     // Catch: Throwable -> L21
        boolean r11 = true;
        int r12 = r10.i() + 0;
        this.f14962b.a().g();     // Catch: Exception -> L9 Throwable -> L21
        boolean r1 = false;
    L14:
        this.f14962b.a().f();     // Catch: Throwable -> L21
        if (r1 == false) goto L18;
        r11 = false;
    L18:
        Pair<Boolean, Integer> r2 = new Pair(Boolean.valueOf(r11), Integer.valueOf(r12));     // Catch: Throwable -> L21
        monitor-exit(this);
        return r2;
    L9:
        e = e;
    L13:
        RuntimeLogger.f14958a.d("SQLiteSearchEngine", "executeDelete error!\n" + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L21
        r1 = true;
    L11:
        e = e;
        r12 = 0;
    L21:
        th = move-exception;
        throw th;
    }
}
