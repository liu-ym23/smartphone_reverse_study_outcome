package com.obric.aiproactive.impl.aidb;

import android.content.Context;
import android.os.SystemClock;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.obric.memorydata.database.manager.proactive.DatabaseManagerOpenHelperFactory;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u0018\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0005J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ4\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0015J.\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bJ\u0013\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0000¢\u0006\u0002\b\u001dJ\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/aiproactive/impl/aidb/AiProactiveDbProvider;", "", "<init>", "()V", "TAG", "", "observableTableNames", "", "dbMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/aiproactive/impl/aidb/AiProactiveDb;", "buildDbName", "userId", "get", "context", "Landroid/content/Context;", "getForCurrentUser", "await", "timeoutMs", "", "pollIntervalMs", "(Landroid/content/Context;Ljava/lang/String;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitForCurrentUser", "(Landroid/content/Context;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyTablesUpdated", "", "tableNames", "", "supportedObservableTableNames", "supportedObservableTableNames$ai_proactive_impl_obricRelease", "create", "dbName", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6306a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f6307b = null;
    private static final ConcurrentHashMap<String, AiProactiveDb> c = null;

    static {
        f6306a = new b();
        f6307b = SetsKt.setOf(new String[]{"ProactiveEventRecords", "ProactiveEca", "ProactiveTrace", "ProactiveRecommendation", "ProactiveDirectFeedback", "ProactiveTask", "ProactivePreference", "ProactiveMessage", "ProactiveMessageBackup", "SpellProactiveEca"});
        c = new ConcurrentHashMap();
    }

    private b() {
    }

    public static /* synthetic */ AiProactiveDb a(b r1, Context r2, int r3, Object r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L6:
        return r1.a(r5);
    }

    private static final boolean a(String r9, AiProactiveDb r10) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveDbProvider", "[DbProvider] refreshInvalidation dbName=" + r9, false, 4, null);     // Catch: Throwable -> L5
        InvalidationTracker r3 = r10.getInvalidationTracker();     // Catch: Throwable -> L5
        String[] r4 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(f6307b, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        r3.notifyObserversByTableNames((String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), String[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
        r10.getInvalidationTracker().refreshVersionsAsync();     // Catch: Throwable -> L5
        Object r11 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r11);
        if (r5 == null) goto L11;
        RunLog.INSTANCE.error("AiProactiveDbProvider", "[DbProvider] refreshInvalidation failed, dbName=" + r9, r5);
    L11:
        if (Result.m1424exceptionOrNullimpl(r11) == null) goto L15;
        r11 = false;
    L15:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final AiProactiveDb b(Context r8, final String r9) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveDbProvider", "[DbProvider] create begin dbName=" + r9, false, 4, null);
        final AiProactiveDb r10 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(Room.databaseBuilder(r7, AiProactiveDb.class, r9).openHelperFactory((SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.preCheckCast(new DatabaseManagerOpenHelperFactory(), SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin")).fallbackToDestructiveMigrationOnDowngrade().addCallback((RoomDatabase.Callback) ZeusTransformUtils.preCheckCast(new AiProactiveDbProvider$create$db$1(r9), RoomDatabase.Callback.class, "com.obric.memorydata.plugin")).build(), AiProactiveDb.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.database.c.f11648a.a(r9, r10.getOpenHelper().getWritableDatabase(), new $$Lambda$b$dXoysDM6UydeWwqj0ImayNgtwk(r9, r10));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveDbProvider", "[DbProvider] create success dbName=" + r9, false, 4, null);
        return r10;
    }

    /* JADX INFO: renamed from: lambda$dX-oysDM6UydeWwqj0ImayNgtwk, reason: not valid java name */
    public static /* synthetic */ boolean m216lambda$dXoysDM6UydeWwqj0ImayNgtwk(String r0, AiProactiveDb r1) {
        return a(r0, r1);
    }

    public final AiProactiveDb a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        return a(r4, AppContext.INSTANCE.getUserId());
    }

    public final AiProactiveDb a(Context r11, String r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r12, "userId");
        String r0 = com.obric.aiproactive.impl.a.a(r12);
        if (r0 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveDbProvider", "[DbProvider] get ignored invalidUserId raw=" + r12, null, 4, null);
        return null;
    L6:
        String r14 = a(r0);
        SupportSQLiteDatabase r2 = com.obric.memorydata.middleware.database.c.f11648a.c(r14);
        if (r2 != null) goto L10;
        RunLog.INSTANCE.debug("AiProactiveDbProvider", "[DbProvider] get databaseNotReady dbName=" + r14 + " userId=" + r0);
        return null;
    L10:
        ConcurrentHashMap<String, AiProactiveDb> r1 = c;
        AiProactiveDb r3 = (AiProactiveDb) ZeusTransformUtils.preCheckCast(r1.get(r14), AiProactiveDb.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L13;
    L16:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveDbProvider", "[DbProvider] get createRoomWrapper dbName=" + r14 + " userId=" + r0 + " version=" + r2.getVersion(), false, 4, null);
        monitor-enter(this);
        b r4 = f6306a;     // Catch: Throwable -> L21
        Context r15 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Intrinsics.checkNotNullExpressionValue(r15, "getApplicationContext(...)");     // Catch: Throwable -> L21
        AiProactiveDb r16 = r4.b(r15, r14);     // Catch: Throwable -> L21
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.memorydata.plugin")).put(r14, r16);     // Catch: Throwable -> L21
        monitor-exit(this);
        return r16;
    L21:
        th = move-exception;
        throw th;
    L13:
        if (r3.getOpenHelper().getWritableDatabase().getVersion() != r2.getVersion()) goto L16;
        RunLog.INSTANCE.debug("AiProactiveDbProvider", "[DbProvider] get hitCache dbName=" + r14 + " userId=" + r0 + " version=" + r2.getVersion());
        return r3;
    }

    public final Object a(Context r23, String r24, long r25, long r27, Continuation<? super AiProactiveDb> r29) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.memorydata.plugin");
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r29, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, AiProactiveDbProvider$await$1.class) == false) goto L7;
        AiProactiveDbProvider$await$1 r3 = (AiProactiveDbProvider$await$1) ZeusTransformUtils.preCheckCast(r2, AiProactiveDbProvider$await$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
        b r4 = this;
    L8:
        Object r5 = r3.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r3.label;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        long r10 = r3.J$2;
        long r12 = r3.J$1;
        long r14 = r3.J$0;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r3.L$2, String.class, "com.obric.memorydata.plugin");
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(r3.L$1, Context.class, "com.obric.memorydata.plugin");
        b r9 = (b) ZeusTransformUtils.preCheckCast(r3.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        Context r11 = r8;
        r4 = r9;
        long r13 = r12;
        long r15 = r14;
        long r16 = r10;
    L21:
        if ((SystemClock.elapsedRealtime() - r16) >= r15) goto L29;
        AiProactiveDb r17 = r4.a(r11, r1);
        if (r17 != null) goto L24;
        r3.L$0 = r4;
        r3.L$1 = r11;
        r3.L$2 = r1;
        r3.J$0 = r15;
        r3.J$1 = r13;
        r3.J$2 = r16;
        r3.label = 1;
        if (au.a(r13, r3) != r6) goto L21;
        return r6;
    L24:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveDbProvider", "[DbProvider] await ready userId=" + r1 + " waitedMs=" + (SystemClock.elapsedRealtime() - r16), false, 4, null);
        return r17;
    L29:
        String r18 = "[DbProvider] await timeout userId=" + r1 + " timeoutMs=" + r15;
        Throwable r19 = null;
        int r20 = 4;
        Object r21 = null;
        IRunLog r22 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r26 = "AiProactiveDbProvider";
        String r28 = r18;
    L17:
        IRunLog.a.a(r22, r26, r28, r19, r20, r21);
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        String r30 = com.obric.aiproactive.impl.a.a(r24);
        if (r30 != null) goto L19;
        r19 = null;
        r20 = 4;
        r21 = null;
        r22 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r26 = "AiProactiveDbProvider";
        r28 = "[DbProvider] await ignored invalidUserId raw=" + r24;
        goto L17
    L19:
        long r31 = SystemClock.elapsedRealtime();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveDbProvider", "[DbProvider] await start userId=" + r30 + " timeoutMs=" + r25 + " pollIntervalMs=" + r27, false, 4, null);
        r16 = r31;
        r13 = r27;
        r11 = r0;
        r1 = r30;
        r15 = r25;
    L7:
        r4 = this;
        r3 = new AiProactiveDbProvider$await$1(r4, r2);
        goto L8
    }

    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        return "ai_proactive_" + r2 + ".db";
    }

    public final Set<String> a() {
        return f6307b;
    }

    public final boolean a(Collection<String> r11) {
        Collection r12 = (Collection) ZeusTransformUtils.wrapperContextForParams(r11, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "tableNames");
        AiProactiveDb r10 = a(this, null, 1, null);
        if (r10 != null) goto L7;
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r4 = null;
        int r5 = 4;
        Object r6 = null;
        String r2 = "AiProactiveDbProvider";
        String r3 = "[DbProvider] notifyTablesUpdated skipped dbNotReady";
    L5:
        IRunLog.a.a(r1, r2, r3, r4, r5, r6);
        return false;
    L7:
        List<String> r7 = c.a(r12);
        if (r7.isEmpty() == false) goto L23;
        r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r3 = "[DbProvider] notifyTablesUpdated skipped unsupportedTables=" + r12;
        r4 = null;
        r5 = 4;
        r6 = null;
        r2 = "AiProactiveDbProvider";
        goto L5
    L23:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L12
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveDbProvider", "[DbProvider] notifyTablesUpdated tables=" + r7, false, 4, null);     // Catch: Throwable -> L12
        InvalidationTracker r14 = r10.getInvalidationTracker();     // Catch: Throwable -> L12
        String[] r8 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        r14.notifyObserversByTableNames((String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r8, r8.length), String[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
        r10.getInvalidationTracker().refreshVersionsAsync();     // Catch: Throwable -> L12
        Object r15 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L12
    L14:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r15);
        if (r16 == null) goto L18;
        RunLog.INSTANCE.error("AiProactiveDbProvider", "[DbProvider] notifyTablesUpdated failed tables=" + r7, r16);
    L18:
        if (Result.m1424exceptionOrNullimpl(r15) == null) goto L22;
        r15 = false;
    L22:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L12:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
