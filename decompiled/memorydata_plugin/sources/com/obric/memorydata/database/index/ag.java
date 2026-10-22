package com.obric.memorydata.database.index;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003\u0012>\u0010\t\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\n\u0012\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0017R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RF\u0010\t\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardHourlyCoverageRunner;", "", "nowMs", "Lkotlin/Function0;", "", "watermark", "Lcom/obric/memorydata/database/index/CoverageHourWatermark;", "policyProvider", "Lcom/obric/memorydata/database/index/CoveragePolicyIdentity;", "collector", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "snapshotAtMs", "policy", "", "Lcom/obric/memorydata/database/index/CoverageMetric;", "report", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lcom/obric/memorydata/database/index/CoverageHourWatermark;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "onNaturalRunOpportunity", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<Long> f9337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f9338b;
    private final Function0<i> c;
    private final Function2<Long, i, List<h>> d;
    private final Function1<List<h>, Boolean> e;

    public ag(Function0<Long> r3, g r4, Function0<i> r5, Function2<? super Long, ? super i, ? extends List<h>> r6, Function1<? super List<h>, Boolean> r7) {
        Function0<Long> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        g r9 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
        Function0<i> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Function2<Long, i, List<h>> r11 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        Function1<List<h>, Boolean> r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "nowMs");
        Intrinsics.checkNotNullParameter(r9, "watermark");
        Intrinsics.checkNotNullParameter(r10, "policyProvider");
        Intrinsics.checkNotNullParameter(r11, "collector");
        Intrinsics.checkNotNullParameter(r12, "report");
        this.f9337a = r8;
        this.f9338b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r12;
    }

    public final synchronized void a() {
        monitor-enter(this);
        i r0 = (i) ZeusTransformUtils.preCheckCast(this.c.invoke(), i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        if (r0 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r0.a() > 0) goto L11;
        monitor-exit(this);
        return;
    L11:
        long r1 = ((Number) ZeusTransformUtils.preCheckCast(this.f9337a.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L29
        long r3 = Math.floorDiv(r1, ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS);     // Catch: Throwable -> L29
        if (r3 > this.f9338b.a()) goto L16;
        monitor-exit(this);
        return;
    L16:
        List<h> r2 = (List) ZeusTransformUtils.preCheckCast(this.d.invoke(Long.valueOf(r1), r0), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        if (r2 != null) goto L21;
        monitor-exit(this);
        return;
    L21:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L23;
    L26:
        this.f9338b.a(r3);     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L23:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.e.invoke(r2), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L26;
        monitor-exit(this);
        return;
    L29:
        th = move-exception;
        throw th;
    }
}
