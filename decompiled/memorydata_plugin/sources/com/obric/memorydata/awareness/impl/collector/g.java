package com.obric.memorydata.awareness.impl.collector;

import android.content.Context;
import android.os.StatFs;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.af;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\n\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0002J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/awareness/impl/collector/StorageUsagePercentFeatureCollector;", "Lcom/obric/memorydata/awareness/impl/collector/FeatureCollector;", "Lcom/obric/memorydata/utils/MemoryAppStateListener$AppSwitchListener;", "<init>", "()V", "abilityManager", "Lcom/obric/memorydata/ability/AbilityManager;", "updateInFlight", "Ljava/util/concurrent/atomic/AtomicBoolean;", "screenOnReceiver", "com/obric/memorydata/awareness/impl/collector/StorageUsagePercentFeatureCollector$screenOnReceiver$1", "Lcom/obric/memorydata/awareness/impl/collector/StorageUsagePercentFeatureCollector$screenOnReceiver$1;", "startCollect", "", "stopCollect", "requestUpdate", "computeUsagePercent", "", "()Ljava/lang/Double;", "roundStorageSize", "", "size", "onAppOpen", "appName", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "onAppClose", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g extends e implements af.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8646a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.memorydata.ability.d f8647b;
    private final AtomicBoolean c;
    private final b d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/awareness/impl/collector/StorageUsagePercentFeatureCollector$Companion;", "", "<init>", "()V", "TAG", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/awareness/impl/collector/StorageUsagePercentFeatureCollector$screenOnReceiver$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f8648a;

        b(g r1) {
            this.f8648a = r1;
        }

        @Override // com.obric.memorydata.ability.k
        public void a(h r3) {
            Intrinsics.checkNotNullParameter((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin"), "data");
            g.a(this.f8648a);
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    static {
        f8646a = new a(null);
    }

    public g() {
        this.f8647b = new com.obric.memorydata.ability.d();
        this.c = new AtomicBoolean(false);
        this.d = new b(this);
    }

    private final long a(long r11) {
        if (r11 > 0) goto L5;
        return r11;
    L5:
        long r2 = 1;
        long r4 = 1;
        long r6 = 1;
    L7:
        if ((r2 * r4) >= r11) goto L12;
        r2 = r2 << 1;
        if (r2 <= 512) goto L7;
        r6 = r6 * 1000;
        r4 = r4 * 1024;
        r2 = 1;
        goto L7
    L12:
        return r2 * r6;
    }

    private static final Double a(Exception r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        RunLog.INSTANCE.debug("StorageUsagePercent", "computeUsagePercent failed: " + r3.getMessage());
        return null;
    }

    private final void a() {
        if (this.c.compareAndSet(false, true) == true) goto L6;
        RunLog.INSTANCE.debug("StorageUsagePercent", "requestUpdate skipped: updateInFlight");
        return;
    L6:
        ThreadPoolContainer.Companion.execute(new $$Lambda$g$e9urPp8RsMQxZlCWZbbIzpI7ayQ(this));
    }

    public static final /* synthetic */ void a(g r0) {
        r0.a();
    }

    private static final void b(g r12) {
        RunLog.INSTANCE.debug("StorageUsagePercent", "update start");     // Catch: Throwable -> L10
        Double r4 = r12.e();     // Catch: Throwable -> L10
        if (r4 == null) goto L8;
        float r5 = (float) r4.doubleValue();     // Catch: Throwable -> L10
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "StorageUsagePercent", "setFeature STORAGE_USAGE_PERCENT=" + r5, false, 4, null);     // Catch: Throwable -> L10
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "storage_usage_percent", Float.valueOf(r5), null, 4, null);     // Catch: Throwable -> L10
        r12.c.set(false);
        RunLog.INSTANCE.debug("StorageUsagePercent", "update end");
        return;
    L8:
        r12.c.set(false);
        RunLog.INSTANCE.debug("StorageUsagePercent", "update end");
        return;
    L10:
        th = move-exception;
        r12.c.set(false);
        RunLog.INSTANCE.debug("StorageUsagePercent", "update end");
        throw th;
    }

    private static final Double c(g r22) {
        StatFs r1 = new StatFs(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir().getAbsolutePath());
        long r2 = r1.getTotalBytes();
        long r4 = r22.a(r2);
        long r0 = r1.getAvailableBytes();
        if (r4 > 0) goto L5;
        RunLog.INSTANCE.debug("StorageUsagePercent", "computeUsagePercent skipped: totalBytes=" + r4);
        return null;
    L5:
        long r6 = RangesKt.coerceAtLeast(r4 - r0, 0);
        double r10 = (r6 * 100.0d) / r4;
        double r14 = RangesKt.coerceIn(r10, 0.0d, 100.0d);
        RunLog.INSTANCE.debug("StorageUsagePercent", "compute: fileSystemTotal=" + r2 + " total=" + r4 + " available=" + r0 + " used=" + r6 + " raw=" + r10 + " clamped=" + r14);
        return Double.valueOf(MathKt.roundToLong(r14 * 100.0d) / 100.0d);
    }

    private final Double e() {
        return (Double) ZeusTransformUtils.preCheckCast(y.a($$Lambda$g$RQPofRDsRfYiMmu06CQlETxxpzU.INSTANCE, new $$Lambda$g$16VoyvKNKkqQwpp17wEkLfhVxM(this)), Double.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$16VoyvKNKkqQ-wpp17wEkLfhVxM, reason: not valid java name */
    public static /* synthetic */ Double m510lambda$16VoyvKNKkqQwpp17wEkLfhVxM(g r0) {
        return c(r0);
    }

    public static /* synthetic */ Double lambda$RQPofRDsRfYiMmu06CQlETxxpzU(Exception r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$e9urPp8RsMQxZlCWZbbIzpI7ayQ(g r0) {
        b(r0);
    }

    @Override // com.obric.memorydata.utils.af.a
    public void a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "appName");
        Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);
        RunLog.INSTANCE.debug("StorageUsagePercent", "onAppOpen pkg=" + r5 + " app=" + r4);
        a();
    }

    @Override // com.obric.memorydata.awareness.impl.collector.e
    public void b() {
        super.b();
        this.f8647b.a(new com.obric.memorydata.ability.f(100000005, MapsKt.mapOf(TuplesKt.to("mode", com.tom_roush.pdfbox.pdmodel.a.d.f.f))), (k) ZeusTransformUtils.preCheckCast(this.d, k.class, "com.obric.memorydata.plugin"));
        af.f13160a.a((af.a) ZeusTransformUtils.preCheckCast(this, af.a.class, "com.obric.memorydata.plugin"));
        a();
    }

    @Override // com.obric.memorydata.utils.af.a
    public void b(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "appName");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
    }

    @Override // com.obric.memorydata.awareness.impl.collector.e
    public void c() {
        super.c();
        this.f8647b.b(new com.obric.memorydata.ability.f(100000005, MapsKt.mapOf(TuplesKt.to("mode", com.tom_roush.pdfbox.pdmodel.a.d.f.f))), (k) ZeusTransformUtils.preCheckCast(this.d, k.class, "com.obric.memorydata.plugin"));
        af.f13160a.b((af.a) ZeusTransformUtils.preCheckCast(this, af.a.class, "com.obric.memorydata.plugin"));
    }
}
