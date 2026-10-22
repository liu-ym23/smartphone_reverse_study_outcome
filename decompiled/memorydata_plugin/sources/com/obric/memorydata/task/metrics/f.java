package com.obric.memorydata.task.metrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0002\u0010\u0019R\u001e\u0010\t\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/task/metrics/IndexPowerMetricsRuntime;", "", "store", "Lcom/obric/memorydata/task/metrics/IndexPowerMetricsStore;", "eventSink", "Lcom/obric/memorydata/task/metrics/IndexPowerMetricsEventSink;", "clock", "Lkotlin/Function0;", "", "onError", "Lkotlin/Function1;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "<init>", "(Lcom/obric/memorydata/task/metrics/IndexPowerMetricsStore;Lcom/obric/memorydata/task/metrics/IndexPowerMetricsEventSink;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "coordinator", "Lcom/obric/memorydata/task/metrics/IndexPowerMetricsCoordinator;", "observe", "commonSatisfied", "", "strictlySatisfied", "pendingTaskNames", "", "", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Collection;)V", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<RuntimeException, Unit> f12943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f12944b;

    public f(j r3, e r4, Function0<Long> r5, Function1<? super RuntimeException, Unit> r6) {
        j r7 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        e r8 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
        Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Function1<RuntimeException, Unit> r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "store");
        Intrinsics.checkNotNullParameter(r8, "eventSink");
        Intrinsics.checkNotNullParameter(r9, "clock");
        Intrinsics.checkNotNullParameter(r10, "onError");
        this.f12943a = r10;
        this.f12944b = new c(r7, r8, r9, r10);
    }

    public /* synthetic */ f(j r2, e r3, Function0 r4, Function1 r5, int r6, DefaultConstructorMarker r7) {
        j r8 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.memorydata.plugin");
        e r9 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r10 = (Function0) ZeusTransformUtils.preCheckCast(IndexPowerMetricsRuntime$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
    L6:
        if ((r6 & 8) == 0) goto L8;
        r11 = $$Lambda$f$maOSdKG9a0ldc3rUrlr9r6o5G4.INSTANCE;
    L8:
        this(r8, r9, r10, r11);
    }

    private static final Unit a(RuntimeException r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$maOSdKG9a0-ldc3rUrlr9r6o5G4, reason: not valid java name */
    public static /* synthetic */ Unit m1194lambda$maOSdKG9a0ldc3rUrlr9r6o5G4(RuntimeException r0) {
        return a(r0);
    }

    public final void a(Boolean r3, Boolean r4, Collection<String> r5) {
        Collection<String> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "pendingTaskNames");
        this.f12944b.a(r3, r4, r6);
    }
}
