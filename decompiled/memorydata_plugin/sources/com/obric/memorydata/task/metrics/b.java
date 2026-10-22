package com.obric.memorydata.task.metrics;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/task/metrics/IndexPowerMetrics;", "", "<init>", "()V", "TAG", "", "STORE_KEY", "runtime", "Lcom/obric/memorydata/task/metrics/IndexPowerMetricsRuntime;", "getRuntime", "()Lcom/obric/memorydata/task/metrics/IndexPowerMetricsRuntime;", "runtime$delegate", "Lkotlin/Lazy;", "observe", "", "commonSatisfied", "", "strictlySatisfied", "pendingTaskNames", "", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Collection;)V", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12939a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f12940b = null;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/task/metrics/IndexPowerMetrics$runtime$2$1", "Lcom/obric/memorydata/task/metrics/IndexPowerMetricsStore;", "load", "Lcom/obric/memorydata/task/metrics/IndexPowerMetricsState;", "save", "", "state", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements j {
        a() {
        }

        @Override // com.obric.memorydata.task.metrics.j
        public h a() {
            String r8 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString("entity_index_dashboard_power_state_v2", "");
            if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L6;
            return new h(null, null, null, null, 15, null);
        L6:
            return i.f12947a.a(r8);
        }

        @Override // com.obric.memorydata.task.metrics.j
        public void a(h r5) {
            Intrinsics.checkNotNullParameter(r5, "state");
            IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("entity_index_dashboard_power_state_v2", i.f12947a.a(r5));
        }
    }

    static {
        f12939a = new b();
        f12940b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, $$Lambda$b$zvvNl5SiDjvNyvX5tRZZyu1FY8s.INSTANCE);
    }

    private b() {
    }

    private final f a() {
        return (f) ZeusTransformUtils.preCheckCast(f12940b.getValue(), f.class, "com.obric.memorydata.plugin");
    }

    private static final Unit a(RuntimeException r3) {
        Intrinsics.checkNotNullParameter(r3, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);
        RunLog.INSTANCE.error("IndexPowerMetrics", "index power metrics failed", (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final boolean a(com.obric.memorydata.task.metrics.a r2) {
        Intrinsics.checkNotNullParameter(r2, "sample");
        return Tracker.INSTANCE.reportEventAccepted("entity_index_dashboard_power", g.a(r2));
    }

    private static final f b() {
        return new f((j) ZeusTransformUtils.preCheckCast(new a(), j.class, "com.obric.memorydata.plugin"), $$Lambda$b$9yphuhCnbRSY9C2a2KqCeMkIdA.INSTANCE, null, $$Lambda$b$JgaYq9kcSjGCaIOPkljgHiyXtH8.INSTANCE, 4, null);
    }

    /* JADX INFO: renamed from: lambda$9yphuhCnbRSY9C2-a2KqCeMkIdA, reason: not valid java name */
    public static /* synthetic */ boolean m1193lambda$9yphuhCnbRSY9C2a2KqCeMkIdA(com.obric.memorydata.task.metrics.a r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$JgaYq9kcSjGCaIOPkljgHiyXtH8(RuntimeException r0) {
        return a(r0);
    }

    public static /* synthetic */ f lambda$zvvNl5SiDjvNyvX5tRZZyu1FY8s() {
        return b();
    }

    public final void a(Boolean r3, Boolean r4, Collection<String> r5) {
        Collection<String> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "pendingTaskNames");
        a().a(r3, r4, r6);
    }
}
