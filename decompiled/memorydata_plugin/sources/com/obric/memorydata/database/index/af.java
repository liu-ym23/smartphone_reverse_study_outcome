package com.obric.memorydata.database.index;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0086\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012)\u0010\u0007\u001a%\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\b\u0012<\u0010\u000e\u001a8\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0014\u001a\u00020\u0015R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010\u0007\u001a%\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\bX\u0082\u0004¢\u0006\u0002\n\u0000RD\u0010\u000e\u001a8\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardDailyBacklogRunner;", "", "nowMs", "Lkotlin/Function0;", "", "watermark", "Lcom/obric/memorydata/database/index/BacklogDayWatermark;", "collector", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "snapshotAtMs", "", "Lcom/obric/memorydata/database/index/BacklogMetric;", "report", "Lkotlin/Function2;", "metrics", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lcom/obric/memorydata/database/index/BacklogDayWatermark;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "onNaturalRunOpportunity", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<Long> f9335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f9336b;
    private final Function1<Long, List<b>> c;
    private final Function2<Long, List<b>, Boolean> d;

    public af(Function0<Long> r3, a r4, Function1<? super Long, ? extends List<b>> r5, Function2<? super Long, ? super List<b>, Boolean> r6) {
        Function0<Long> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        Function1<Long, List<b>> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Function2<Long, List<b>, Boolean> r10 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "nowMs");
        Intrinsics.checkNotNullParameter(r8, "watermark");
        Intrinsics.checkNotNullParameter(r9, "collector");
        Intrinsics.checkNotNullParameter(r10, "report");
        this.f9335a = r7;
        this.f9336b = r8;
        this.c = r9;
        this.d = r10;
    }

    public final synchronized void a() {
        monitor-enter(this);
        long r0 = ((Number) ZeusTransformUtils.preCheckCast(this.f9335a.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L21
        long r2 = Math.floorDiv(r0, WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS);     // Catch: Throwable -> L21
        if (r2 > this.f9336b.a()) goto L8;
        monitor-exit(this);
        return;
    L8:
        List<b> r4 = (List) ZeusTransformUtils.preCheckCast(this.c.invoke(Long.valueOf(r0)), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r4 != null) goto L13;
        monitor-exit(this);
        return;
    L13:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L15;
    L18:
        this.f9336b.a(r2);     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L15:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.d.invoke(Long.valueOf(r0), r4), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L18;
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
