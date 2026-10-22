package com.obric.memorydata.memory;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/InAppSignalSettingsRefreshController;", "", "minIntervalMs", "", "elapsedRealtime", "Lkotlin/Function0;", "refresh", "", "<init>", "(JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "lock", "lastSuccessfulRefreshMs", "requestRefresh", "", InfoRequestQPSOptTraceLogger.REASON, "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<Long> f10371b;
    private final Function0<Unit> c;
    private final Object d;
    private long e;

    public r(long r3, Function0<Long> r5, Function0<Unit> r6) {
        Function0<Long> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "elapsedRealtime");
        Intrinsics.checkNotNullParameter(r8, "refresh");
        this.f10370a = r3;
        this.f10371b = r7;
        this.c = r8;
        this.d = new Object();
        this.e = Long.MIN_VALUE;
    }

    public final boolean a(String r9) {
        Intrinsics.checkNotNullParameter(r9, InfoRequestQPSOptTraceLogger.REASON);
        long r0 = ((Number) ZeusTransformUtils.preCheckCast(this.f10371b.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue();
        Object r10 = this.d;
        monitor-enter(r10);
        long r2 = this.e;     // Catch: Throwable -> L21
        if (r2 != Long.MIN_VALUE) goto L8;
    L26:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        r r8 = (r) ZeusTransformUtils.preCheckCast(this, r.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        r8.c.invoke();     // Catch: Throwable -> L13
        r8.e = r0;     // Catch: Throwable -> L13
        Object r11 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L13
    L16:
        if (Result.m1427isFailureimpl(r11) == false) goto L18;
        r11 = false;
    L18:
        boolean r12 = ((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Throwable -> L21
        monitor-exit(r10);
        return r12;
    L13:
        th = move-exception;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L21
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L21
        goto L16
    L8:
        if ((r0 - r2) >= this.f10370a) goto L26;
        monitor-exit(r10);
        return false;
    L21:
        th = move-exception;
        throw th;
    }
}
