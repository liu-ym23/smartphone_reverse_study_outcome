package com.obric.memorydata.database.account_split;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ>\u0010\u000e\u001a\u00020\r26\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\r0\u0010J\u0006\u0010\u0016\u001a\u00020\u0011J\b\u0010\u0017\u001a\u00020\rH\u0007J\b\u0010\u0018\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/database/account_split/PersonalDbSplitMigrator;", "", "<init>", "()V", "TAG", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "job", "Lkotlinx/coroutines/Job;", "lastMigratedRowCount", "", "migrateCurrentProfileIfNeeded", "", "invokeOnCurrentMigrationFinished", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "migrationDone", "migratedRowCount", "isCurrentProfileMigrationDone", "migrateCurrentProfileIfNeededBlocking", "ensureMigrationJobStarted", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f8832a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f8833b = null;
    private static volatile bx c;
    private static volatile int d;

    static {
        f8832a = new v();
        f8833b = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
    }

    private v() {
    }

    private static final Unit a(Function2 r1, Throwable r2) {
        ((Function2) ZeusTransformUtils.wrapperContextForParams(r1, Function2.class, "com.obric.memorydata.plugin")).invoke(Boolean.valueOf(f8832a.b()), Integer.valueOf(d));
        return Unit.INSTANCE;
    }

    private final synchronized bx d() {
        monitor-enter(this);
        bx r0 = c;     // Catch: Throwable -> L17
        if (r0 == null) goto L14;
        if (r0.a() == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitMigrator", "migration job already active, job=" + r0, false, 4, null);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r0;
    L14:
        d = 0;     // Catch: Throwable -> L17
        bx r1 = kotlinx.coroutines.i.a(f8833b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new PersonalDbSplitMigrator$ensureMigrationJobStarted$3(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L17
        c = r1;     // Catch: Throwable -> L17
        monitor-exit(this);
        return r1;
    L17:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: lambda$bj3VyVCMUdc37TTiU91u3tGca-o, reason: not valid java name */
    public static /* synthetic */ Unit m537lambda$bj3VyVCMUdc37TTiU91u3tGcao(Function2 r0, Throwable r1) {
        return a(r0, r1);
    }

    public final synchronized void a() {
        monitor-enter(this);
        d();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void a(Function2<? super Boolean, ? super Integer, Unit> r4) {
        final Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "callback");
        bx r0 = c;
        if (r0 != null) goto L5;
    L7:
        r0 = null;
    L8:
        if (r0 != null) goto L11;
        r5.invoke(Boolean.valueOf(b()), Integer.valueOf(d));
        return;
    L11:
        r0.a(new $$Lambda$v$bj3VyVCMUdc37TTiU91u3tGcao(r5));
        return;
    L5:
        if (r0.a() == false) goto L7;
        goto L7
    }

    public final boolean b() {
        return com.obric.memorydata.database.account_split.spliter.b.f8819a.a();
    }

    public final void c() {
        d = com.obric.memorydata.database.account_split.spliter.b.f8819a.b();
    }
}
