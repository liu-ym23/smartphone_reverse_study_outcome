package com.obric.memorydata.awareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012&\u0010\u0004\u001a\"\u0012\u0018\u0012\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0004\u001a\"\u0012\u0018\u0012\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/awareness/LocationQueryCoordinator;", "", "timeoutMillis", "", "startQuery", "Lkotlin/Function1;", "", "", "", "<init>", "(JLkotlin/jvm/functions/Function1;)V", "requestLock", "inFlight", "Ljava/util/concurrent/CompletableFuture;", "awaitLocation", "isRequesting", "", "getOrStartRequest", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<Function1<? super List<Double>, Unit>, Unit> f8543b;
    private final Object c;
    private volatile CompletableFuture<List<Double>> d;

    public c(long r3, Function1<? super Function1<? super List<Double>, Unit>, Unit> r5) {
        Function1<Function1<? super List<Double>, Unit>, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "startQuery");
        this.f8542a = r3;
        this.f8543b = r6;
        this.c = new Object();
    }

    private static final Unit a(c r1, CompletableFuture r2, List r3, Throwable r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Object r6 = r1.c;
        monitor-enter(r6);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r1.d != r2) goto L7;
        r1.d = null;     // Catch: Throwable -> L11
    L7:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r6);
        return Unit.INSTANCE;
    }

    private static final Unit a(CompletableFuture r2, List r3) {
        r2.complete((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final void a(Function2 r2, Object r3, Object r4) {
        ((Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin")).invoke(r3, r4);
    }

    private final CompletableFuture<List<Double>> c() {
        Object r0 = this.c;
        monitor-enter(r0);
        final CompletableFuture<List<Double>> r1 = this.d;     // Catch: Throwable -> L14
        if (r1 != null) goto L7;
    L11:
        r1 = new CompletableFuture();     // Catch: Throwable -> L14
        this.d = r1;     // Catch: Throwable -> L14
        final Function2 r2 = new $$Lambda$c$KH2qencI1_IBC_CQYN9LKjTciJU(this, r1);     // Catch: Throwable -> L14
        r1.whenComplete(new $$Lambda$c$0e3p0ZZTtxRR4JxZTfWUK8lwzuQ(r2));     // Catch: Throwable -> L14
        this.f8543b.invoke(new $$Lambda$c$obVzDrES_ZrVQiqRrKRuALvQTc(r1));     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);
        return r1;
    L7:
        if (r1.isDone() == false) goto L10;
        r1 = null;
    L10:
        if (r1 != null) goto L12;
    L14:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void lambda$0e3p0ZZTtxRR4JxZTfWUK8lwzuQ(Function2 r0, Object r1, Object r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$KH2qencI1_IBC_CQYN9LKjTciJU(c r0, CompletableFuture r1, List r2, Throwable r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$obVzD-rES_ZrVQiqRrKRuALvQTc, reason: not valid java name */
    public static /* synthetic */ Unit m482lambda$obVzDrES_ZrVQiqRrKRuALvQTc(CompletableFuture r0, List r1) {
        return a(r0, r1);
    }

    public final List<Double> a() {
        goto L11
    L10:
        return (List) ZeusTransformUtils.preCheckCast(c().get(this.f8542a, TimeUnit.MILLISECONDS), List.class, "com.obric.memorydata.plugin");
    L5:
        Thread.currentThread().interrupt();
        return null;
    L11:
        return null;
    }

    public final boolean b() {
        CompletableFuture<List<Double>> r1 = this.d;
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.isDone() == true) goto L9;
        return true;
    L9:
        return false;
    }
}
