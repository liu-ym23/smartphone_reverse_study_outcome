package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\t\u0010\u001a\u001a\u00020\u000eH\u0096\u0001J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u001a\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010 \u001a\u00020\u0016H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/room/QueryInterceptorStatement;", "Landroidx/sqlite/db/SupportSQLiteStatement;", "delegate", "sqlStatement", "", "queryCallbackExecutor", "Ljava/util/concurrent/Executor;", "queryCallback", "Landroidx/room/RoomDatabase$QueryCallback;", "(Landroidx/sqlite/db/SupportSQLiteStatement;Ljava/lang/String;Ljava/util/concurrent/Executor;Landroidx/room/RoomDatabase$QueryCallback;)V", "bindArgsCache", "", "", "bindBlob", "", "index", "", EventBody.KEY_VALUE, "", "bindDouble", "", "bindLong", "", "bindNull", "bindString", "clearBindings", IslandSession.REOPEN_VALUE_CLOSE, "execute", "executeInsert", "executeUpdateDelete", "saveArgsToCache", "bindIndex", "simpleQueryForLong", "simpleQueryForString", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class QueryInterceptorStatement implements SupportSQLiteStatement {
    private final List<Object> bindArgsCache;
    private final SupportSQLiteStatement delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;
    private final String sqlStatement;

    public QueryInterceptorStatement(SupportSQLiteStatement r3, String r4, Executor r5, RoomDatabase.QueryCallback r6) {
        SupportSQLiteStatement r7 = (SupportSQLiteStatement) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteStatement.class, "com.obric.memorydata.plugin");
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
        RoomDatabase.QueryCallback r9 = (RoomDatabase.QueryCallback) ZeusTransformUtils.wrapperContextForParams(r6, RoomDatabase.QueryCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "delegate");
        Intrinsics.checkNotNullParameter(r4, "sqlStatement");
        Intrinsics.checkNotNullParameter(r8, "queryCallbackExecutor");
        Intrinsics.checkNotNullParameter(r9, "queryCallback");
        this.delegate = r7;
        this.sqlStatement = r4;
        this.queryCallbackExecutor = r8;
        this.queryCallback = r9;
        this.bindArgsCache = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    private static final void execute$lambda$0(QueryInterceptorStatement r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.queryCallback.onQuery(r2.sqlStatement, r2.bindArgsCache);
    }

    private static final void executeInsert$lambda$2(QueryInterceptorStatement r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.queryCallback.onQuery(r2.sqlStatement, r2.bindArgsCache);
    }

    private static final void executeUpdateDelete$lambda$1(QueryInterceptorStatement r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.queryCallback.onQuery(r2.sqlStatement, r2.bindArgsCache);
    }

    public static /* synthetic */ void lambda$Pmi7YUr_0sVZjB_L4FDjiZZURU8(QueryInterceptorStatement r0) {
        simpleQueryForLong$lambda$3(r0);
    }

    public static /* synthetic */ void lambda$QdLFHZkpmZJ_LPUgODEMde_afXU(QueryInterceptorStatement r0) {
        execute$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$Ry-pL5WhdgLiTeBboZW8YGkMwwQ, reason: not valid java name */
    public static /* synthetic */ void m60lambda$RypL5WhdgLiTeBboZW8YGkMwwQ(QueryInterceptorStatement r0) {
        executeUpdateDelete$lambda$1(r0);
    }

    public static /* synthetic */ void lambda$sZPNtLZUec1i4RI8FPsPU8yXMwU(QueryInterceptorStatement r0) {
        executeInsert$lambda$2(r0);
    }

    /* JADX INFO: renamed from: lambda$sfBXlNb-XvWZ8iQIzcxh0kX5ho8, reason: not valid java name */
    public static /* synthetic */ void m61lambda$sfBXlNbXvWZ8iQIzcxh0kX5ho8(QueryInterceptorStatement r0) {
        simpleQueryForString$lambda$4(r0);
    }

    private final void saveArgsToCache(int r5, Object r6) {
        int r7 = r5 - 1;
        if (r7 < this.bindArgsCache.size()) goto L7;
        int r0 = (r7 - this.bindArgsCache.size()) + 1;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        this.bindArgsCache.add(null);
        r1 = r1 + 1;
    L7:
        this.bindArgsCache.set(r7, r6);
    }

    private static final void simpleQueryForLong$lambda$3(QueryInterceptorStatement r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.queryCallback.onQuery(r2.sqlStatement, r2.bindArgsCache);
    }

    private static final void simpleQueryForString$lambda$4(QueryInterceptorStatement r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.queryCallback.onQuery(r2.sqlStatement, r2.bindArgsCache);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
        saveArgsToCache(r2, r3);
        this.delegate.bindBlob(r2, r3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r2, double r3) {
        saveArgsToCache(r2, Double.valueOf(r3));
        this.delegate.bindDouble(r2, r3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r2, long r3) {
        saveArgsToCache(r2, Long.valueOf(r3));
        this.delegate.bindLong(r2, r3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r4) {
        Object[] r0 = ((Collection) ZeusTransformUtils.preCheckCast(this.bindArgsCache, Collection.class, "com.obric.memorydata.plugin")).toArray(new Object[0]);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        saveArgsToCache(r4, Arrays.copyOf(r0, r0.length));
        this.delegate.bindNull(r4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
        saveArgsToCache(r2, r3);
        this.delegate.bindString(r2, r3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.bindArgsCache.clear();
        this.delegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        this.queryCallbackExecutor.execute(new $$Lambda$QueryInterceptorStatement$QdLFHZkpmZJ_LPUgODEMde_afXU(this));
        this.delegate.execute();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        this.queryCallbackExecutor.execute(new $$Lambda$QueryInterceptorStatement$sZPNtLZUec1i4RI8FPsPU8yXMwU(this));
        return this.delegate.executeInsert();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        this.queryCallbackExecutor.execute(new $$Lambda$QueryInterceptorStatement$RypL5WhdgLiTeBboZW8YGkMwwQ(this));
        return this.delegate.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        this.queryCallbackExecutor.execute(new $$Lambda$QueryInterceptorStatement$Pmi7YUr_0sVZjB_L4FDjiZZURU8(this));
        return this.delegate.simpleQueryForLong();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public String simpleQueryForString() {
        this.queryCallbackExecutor.execute(new $$Lambda$QueryInterceptorStatement$sfBXlNbXvWZ8iQIzcxh0kX5ho8(this));
        return this.delegate.simpleQueryForString();
    }
}
