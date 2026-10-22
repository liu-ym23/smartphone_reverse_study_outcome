package com.obric.memorydata.aikernelcore.bridge;

import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.crash.Ensure;
import com.obric.memorydata.aikernelcore.h;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.g;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.database.DatabaseIsolationTracker;
import com.obric.memorydata.utils.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0003J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0003J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0003J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0003J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/aikernelcore/bridge/DatabaseBridge;", "", "<init>", "()V", "TAG", "", "MAX_RESULT_SIZE_BYTES", "", "SLOW_SQL_THRESHOLD_MS", "", "executeBatch", "dbName", "payload", "querySql", "sql", "execSql", "warnIfSlowSql", "", "operation", "timing", "Lcom/obric/memorydata/aikernelcore/bridge/SqlCallTiming;", "notifyRoomChanged", "resolveDatabaseName", "reportIfAnonymousPersonalAccess", "targetDbName", "checkLargeResult", "result", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DatabaseBridge {
    public static final DatabaseBridge INSTANCE = null;
    private static final int MAX_RESULT_SIZE_BYTES = 204800;
    private static final long SLOW_SQL_THRESHOLD_MS = 5000;
    private static final String TAG = "DatabaseBridge";

    static {
        INSTANCE = new DatabaseBridge();
    }

    private DatabaseBridge() {
    }

    private final void checkLargeResult(String r7, String r8) {
        if (r7.length() >= 102400) goto L5;
        return;
    L5:
        byte[] r6 = r7.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r6, "getBytes(...)");
        int r9 = r6.length;
        if (r9 <= MAX_RESULT_SIZE_BYTES) goto L9;
        String r10 = "OOMChecker: DatabaseBridge " + r8 + " result too large: size=" + (r9 / 1024) + "KB > 200KB";
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, r10, null, 4, null);
        Ensure.ensureNotReachHere(new Throwable(r10 + "\ncontent: " + q.f13259a.c(StringsKt.take(r7, 50))), r10 + ", sql=" + r8);
        return;
    }

    @com.obric.aee.utils.a
    private final String execSql(final String r6, final String r7) {
        f r2 = new f();
        final String r8 = (String) ZeusTransformUtils.preCheckCast(r2.a("routeMs", new $$Lambda$DatabaseBridge$HqFhgw0mqYdglqNwGV8zoyVyswQ(r6, r7)), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        SupportSQLiteDatabase r9 = (SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(r2.a("getDbMs", new $$Lambda$DatabaseBridge$AW7goP9eHIi1qqsJu_BaYp65zlc(r8)), SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        final e r10 = c.f8471a.update(r9, r7, r2);     // Catch: Throwable -> L10
        List<List<d>> r3 = r10.a();     // Catch: Throwable -> L10
        if (r3 == null) goto L6;
        int r4 = r3.size();     // Catch: Throwable -> L10
    L7:
        r2.a(r4);     // Catch: Throwable -> L10
        final String r11 = (String) ZeusTransformUtils.preCheckCast(r2.a("serializeMs", new $$Lambda$DatabaseBridge$CjGOeajclMb_neJVfQCNDEeR8(r10)), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        r2.b(r11.length());     // Catch: Throwable -> L10
        r2.a("checkResultMs", new $$Lambda$DatabaseBridge$KhNY_5TWdtTarTbKIIDYZMPN5To(r11, r7));     // Catch: Throwable -> L10
        warnIfSlowSql("execSql", r2);
        return r11;
    L6:
        r4 = 0;
    L10:
        th = move-exception;
        warnIfSlowSql("execSql", r2);
        throw th;
    }

    private static final String execSql$lambda$4(String r1, String r2) {
        return INSTANCE.resolveDatabaseName(r1, r2);
    }

    private static final SupportSQLiteDatabase execSql$lambda$5(String r1) {
        return com.obric.memorydata.middleware.database.c.f11648a.b(r1);
    }

    private static final String execSql$lambda$6(e r0) {
        return r0.b();
    }

    private static final Unit execSql$lambda$7(String r1, String r2) {
        INSTANCE.checkLargeResult(r1, r2);
        return Unit.INSTANCE;
    }

    @com.obric.aee.utils.a
    private final String executeBatch(String r1, String r2) {
        return a.f8466a.a(r1, r2);
    }

    /* JADX INFO: renamed from: lambda$-CjGOeajclMb_neJVf-QCNDEeR8, reason: not valid java name */
    public static /* synthetic */ String m465lambda$CjGOeajclMb_neJVfQCNDEeR8(e r0) {
        return execSql$lambda$6(r0);
    }

    /* JADX INFO: renamed from: lambda$7-2kZXBkxKZXSkbeihNDC4zcwe0, reason: not valid java name */
    public static /* synthetic */ String m466lambda$72kZXBkxKZXSkbeihNDC4zcwe0(String r0, String r1) {
        return querySql$lambda$0(r0, r1);
    }

    public static /* synthetic */ SupportSQLiteDatabase lambda$AW7goP9eHIi1qqsJu_BaYp65zlc(String r0) {
        return execSql$lambda$5(r0);
    }

    public static /* synthetic */ String lambda$HqFhgw0mqYdglqNwGV8zoyVyswQ(String r0, String r1) {
        return execSql$lambda$4(r0, r1);
    }

    public static /* synthetic */ Unit lambda$KhNY_5TWdtTarTbKIIDYZMPN5To(String r0, String r1) {
        return execSql$lambda$7(r0, r1);
    }

    public static /* synthetic */ SupportSQLiteDatabase lambda$SXtdfu3xZtHKNE8yUi9Q3VtfH0E(String r0) {
        return querySql$lambda$1(r0);
    }

    public static /* synthetic */ Unit lambda$cRMIHfBKH1KSdPgOf7ww8Obj4Tc(String r0, String r1) {
        return querySql$lambda$3(r0, r1);
    }

    public static /* synthetic */ String lambda$wSf4qxlnQilE6QIcdSGxLLeW4oU(e r0) {
        return querySql$lambda$2(r0);
    }

    @com.obric.aee.utils.a
    private final String notifyRoomChanged(String r9) {
    L8:
        th = move-exception;
        Ensure.ensureNotReachHere(th);
        return new e(false, -1, th.toString(), null, null, 16, null).b();
    L3:
        if (com.obric.memorydata.middleware.database.c.f11648a.a(com.obric.memorydata.middleware.database.b.f11646a.b(r9)) == false) goto L6;
        e r8 = new e(true, 0, "", null, null, 16, null);     // Catch: Throwable -> L8
    L5:
        return r8.b();
    L6:
        r8 = new e(false, -1, "refresh room invalidation failed", null, null, 16, null);     // Catch: Throwable -> L8
        goto L5
    }

    @com.obric.aee.utils.a
    private final String querySql(final String r6, final String r7) {
        f r2 = new f();
        final String r8 = (String) ZeusTransformUtils.preCheckCast(r2.a("routeMs", new $$Lambda$DatabaseBridge$72kZXBkxKZXSkbeihNDC4zcwe0(r6, r7)), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        SupportSQLiteDatabase r9 = (SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(r2.a("getDbMs", new $$Lambda$DatabaseBridge$SXtdfu3xZtHKNE8yUi9Q3VtfH0E(r8)), SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        final e r10 = c.f8471a.query(r9, r7, r2);     // Catch: Throwable -> L10
        List<List<d>> r3 = r10.a();     // Catch: Throwable -> L10
        if (r3 == null) goto L6;
        int r4 = r3.size();     // Catch: Throwable -> L10
    L7:
        r2.a(r4);     // Catch: Throwable -> L10
        final String r11 = (String) ZeusTransformUtils.preCheckCast(r2.a("serializeMs", new $$Lambda$DatabaseBridge$wSf4qxlnQilE6QIcdSGxLLeW4oU(r10)), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        r2.b(r11.length());     // Catch: Throwable -> L10
        r2.a("checkResultMs", new $$Lambda$DatabaseBridge$cRMIHfBKH1KSdPgOf7ww8Obj4Tc(r11, r7));     // Catch: Throwable -> L10
        warnIfSlowSql("querySql", r2);
        return r11;
    L6:
        r4 = 0;
    L10:
        th = move-exception;
        warnIfSlowSql("querySql", r2);
        throw th;
    }

    private static final String querySql$lambda$0(String r1, String r2) {
        return INSTANCE.resolveDatabaseName(r1, r2);
    }

    private static final SupportSQLiteDatabase querySql$lambda$1(String r1) {
        return com.obric.memorydata.middleware.database.c.f11648a.b(r1);
    }

    private static final String querySql$lambda$2(e r0) {
        return r0.b();
    }

    private static final Unit querySql$lambda$3(String r1, String r2) {
        INSTANCE.checkLargeResult(r1, r2);
        return Unit.INSTANCE;
    }

    private final void reportIfAnonymousPersonalAccess(String r5) {
        if (Intrinsics.areEqual(r5, MemoryDbEngine.USER_LOGIC_DB_NAME) == true) goto L6;
        return;
    L6:
        if (com.obric.memorydata.middleware.database.b.f11646a.a().c() == true) goto L8;
        return;
    L8:
        DatabaseIsolationTracker r4 = DatabaseIsolationTracker.f11642a;
        String r0 = com.obric.memorydata.middleware.database.b.f11646a.b(r5);
        Set<String> r1 = h.f8481a.a();
        String r2 = Thread.currentThread().getName();
        Intrinsics.checkNotNullExpressionValue(r2, "getName(...)");
        r4.a(r5, r0, r1, r2);
    }

    private final String resolveDatabaseName(String r4, String r5) {
        b.a r6 = b.f8467a.a(r4, r5);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6.a(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        DatabaseIsolationTracker.f11642a.a(r4, r6.a(), h.f8481a.a());
    L6:
        if (r6.b() == false) goto L8;
        r4 = MemoryDbEngine.USER_LOGIC_DB_NAME;
    L8:
        reportIfAnonymousPersonalAccess(r4);
        return r4;
    }

    private final void warnIfSlowSql(String r10, f r11) {
        long r0 = r11.a();
        if (r0 <= 5000) goto L6;
        ((o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.c.f11612a, o.class, "com.obric.memorydata.plugin")).a("database_bridge_sql_slow", "数据库接口耗时超过 5 秒 operation=" + r10 + " durationMs=" + r0 + ' ' + r11.b(), new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null), new g().a());
        return;
    }
}
