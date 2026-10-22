package com.obric.memorydata.database.manager.proactive;

import android.content.Context;
import android.os.SystemClock;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.database.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0005J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\rJ4\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0013J.\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/database/manager/proactive/ProactiveRecommendationDbProvider;", "", "<init>", "()V", "TAG", "", "dbMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/database/manager/proactive/ProactiveRecommendationDb;", "buildDbName", "userId", "get", "context", "Landroid/content/Context;", "getForCurrentUser", "await", "timeoutMs", "", "pollIntervalMs", "(Landroid/content/Context;Ljava/lang/String;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitForCurrentUser", "(Landroid/content/Context;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "dbName", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9590a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, ProactiveRecommendationDb> f9591b = null;

    static {
        f9590a = new a();
        f9591b = new ConcurrentHashMap();
    }

    private a() {
    }

    public static /* synthetic */ ProactiveRecommendationDb a(a r1, Context r2, int r3, Object r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L6:
        return r1.a(r5);
    }

    public static /* synthetic */ Object a(a r7, Context r8, long r9, long r11, Continuation r13, int r14, Object r15) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Continuation<? super ProactiveRecommendationDb> r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if ((r14 & 1) == 0) goto L6;
        r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L6:
        if ((r14 & 2) == 0) goto L8;
        long r3 = 5000;
    L10:
        if ((r14 & 4) == 0) goto L12;
        long r5 = 1000;
    L14:
        return r7.a(r0, r3, r5, r2);
    L12:
        r5 = r11;
        goto L14
    L8:
        r3 = r9;
        goto L10
    }

    private static final boolean a(String r8, ProactiveRecommendationDb r9) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveDbProvider", "[DbProvider] refreshInvalidation dbName=" + r8, false, 4, null);     // Catch: Throwable -> L5
        r9.getInvalidationTracker().notifyObserversByTableNames(new String[]{"ProactiveEcaCondition", "ProactiveInspiration", "ProactiveRecommendations"});     // Catch: Throwable -> L5
        r9.getInvalidationTracker().refreshVersionsAsync();     // Catch: Throwable -> L5
        Object r10 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.m1424exceptionOrNullimpl(r10);
        if (r2 == null) goto L11;
        RunLog.INSTANCE.error("ProactiveDbProvider", "[DbProvider] refreshInvalidation failed, dbName=" + r8, r2);
    L11:
        if (Result.m1424exceptionOrNullimpl(r10) == null) goto L15;
        r10 = false;
    L15:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final ProactiveRecommendationDb b(Context r8, final String r9) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveDbProvider", "[DbProvider] create begin dbName=" + r9, false, 4, null);
        final ProactiveRecommendationDb r10 = (ProactiveRecommendationDb) ZeusTransformUtils.preCheckCast(Room.databaseBuilder(r7, ProactiveRecommendationDb.class, r9).openHelperFactory((SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.preCheckCast(new DatabaseManagerOpenHelperFactory(), SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin")).fallbackToDestructiveMigrationOnDowngrade().addCallback((RoomDatabase.Callback) ZeusTransformUtils.preCheckCast(new ProactiveRecommendationDbProvider$create$db$1(r9), RoomDatabase.Callback.class, "com.obric.memorydata.plugin")).build(), ProactiveRecommendationDb.class, "com.obric.memorydata.plugin");
        c.f11648a.a(r9, r10.getOpenHelper().getWritableDatabase(), new $$Lambda$a$alwWs8Y4sjSxHKZNo24fSPObC14(r9, r10));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveDbProvider", "[DbProvider] create success dbName=" + r9, false, 4, null);
        return r10;
    }

    public static /* synthetic */ boolean lambda$alwWs8Y4sjSxHKZNo24fSPObC14(String r0, ProactiveRecommendationDb r1) {
        return a(r0, r1);
    }

    public final ProactiveRecommendationDb a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        return a(r4, AppContext.INSTANCE.getUserId());
    }

    public final ProactiveRecommendationDb a(Context r11, String r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r12, "userId");
        String r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
    L25:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveDbProvider", "[DbProvider] get ignored invalidUserId raw=" + r12, null, 4, null);
        return null;
    L5:
        if (Intrinsics.areEqual(r0, "0") == true) goto L25;
        String r14 = a(r0);
        SupportSQLiteDatabase r1 = c.f11648a.c(r14);
        if (r1 != null) goto L11;
        RunLog.INSTANCE.debug("ProactiveDbProvider", "[DbProvider] get databaseNotReady dbName=" + r14 + " userId=" + r0);
        return null;
    L11:
        ConcurrentHashMap<String, ProactiveRecommendationDb> r2 = f9591b;
        ProactiveRecommendationDb r3 = (ProactiveRecommendationDb) ZeusTransformUtils.preCheckCast(r2.get(r14), ProactiveRecommendationDb.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L14;
    L17:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveDbProvider", "[DbProvider] get createRoomWrapper dbName=" + r14 + " userId=" + r0 + " version=" + r1.getVersion(), false, 4, null);
        monitor-enter(this);
        a r4 = f9590a;     // Catch: Throwable -> L22
        Context r15 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Intrinsics.checkNotNullExpressionValue(r15, "getApplicationContext(...)");     // Catch: Throwable -> L22
        ProactiveRecommendationDb r16 = r4.b(r15, r14);     // Catch: Throwable -> L22
        ((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin")).put(r14, r16);     // Catch: Throwable -> L22
        monitor-exit(this);
        return r16;
    L22:
        th = move-exception;
        throw th;
    L14:
        if (r3.getOpenHelper().getWritableDatabase().getVersion() != r1.getVersion()) goto L17;
        RunLog.INSTANCE.debug("ProactiveDbProvider", "[DbProvider] get hitCache dbName=" + r14 + " userId=" + r0 + " version=" + r1.getVersion());
        return r3;
    }

    public final Object a(Context r11, long r12, long r14, Continuation<? super ProactiveRecommendationDb> r16) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        Continuation<? super ProactiveRecommendationDb> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r16, Continuation.class, "com.obric.memorydata.plugin");
        return a(r3, AppContext.INSTANCE.getUserId(), r12, r14, r9);
    }

    public final Object a(Context r24, String r25, long r26, long r28, Continuation<? super ProactiveRecommendationDb> r30) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r24, Context.class, "com.obric.memorydata.plugin");
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r30, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, ProactiveRecommendationDbProvider$await$1.class) == false) goto L7;
        ProactiveRecommendationDbProvider$await$1 r4 = (ProactiveRecommendationDbProvider$await$1) ZeusTransformUtils.preCheckCast(r3, ProactiveRecommendationDbProvider$await$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
        a r5 = this;
    L8:
        Object r6 = r4.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r4.label;
        if (r8 == 0) goto L14;
        if (r8 != 1) goto L13;
        long r0 = r4.J$2;
        long r11 = r4.J$1;
        long r13 = r4.J$0;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r4.L$2, String.class, "com.obric.memorydata.plugin");
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(r4.L$1, Context.class, "com.obric.memorydata.plugin");
        a r12 = (a) ZeusTransformUtils.preCheckCast(r4.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
        long r14 = r0;
        long r2 = r13;
        long r15 = r11;
        Context r16 = r10;
        String r17 = r9;
        r5 = r12;
    L21:
        if ((SystemClock.elapsedRealtime() - r14) >= r2) goto L29;
        ProactiveRecommendationDb r18 = r5.a(r16, r17);
        if (r18 != null) goto L24;
        r4.L$0 = r5;
        r4.L$1 = r16;
        r4.L$2 = r17;
        r4.J$0 = r2;
        r4.J$1 = r15;
        r4.J$2 = r14;
        r4.label = 1;
        if (au.a(r15, r4) != r7) goto L21;
        return r7;
    L24:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveDbProvider", "[DbProvider] await ready userId=" + r17 + " waitedMs=" + (SystemClock.elapsedRealtime() - r14), false, 4, null);
        return r18;
    L29:
        int r19 = 4;
        Object r20 = null;
        IRunLog r27 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r29 = "ProactiveDbProvider";
        String r210 = "[DbProvider] await timeout userId=" + r17 + " timeoutMs=" + r2;
        Throwable r211 = null;
    L30:
        IRunLog.a.a(r27, r29, r210, r211, r19, r20);
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        String r21 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L17;
    L32:
        String r22 = "[DbProvider] await ignored invalidUserId raw=" + r25;
        r19 = 4;
        r20 = null;
        r27 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r29 = "ProactiveDbProvider";
        r210 = r22;
        r211 = null;
        goto L30
    L17:
        if (Intrinsics.areEqual(r21, "0") == true) goto L32;
        long r110 = SystemClock.elapsedRealtime();
        r15 = r28;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveDbProvider", "[DbProvider] await start userId=" + r21 + " timeoutMs=" + r26 + " pollIntervalMs=" + r15, false, 4, null);
        r17 = r21;
        r14 = r110;
        r16 = r1;
        r2 = r26;
    L7:
        r5 = this;
        r4 = new ProactiveRecommendationDbProvider$await$1(r5, r3);
        goto L8
    }

    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        return "proactive_recommendation_" + r2 + ".db";
    }
}
