package com.obric.lifelog.data;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.memorydata.ability.d;
import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.data.p;
import com.obric.memorydata.ability.f;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.recommend.RecommendApi;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/lifelog/data/LifeLogTrigger;", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "<init>", "()V", "TAG", "", "lastTriggerTs", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "onDataReceive", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "lifelog_data_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8050a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f8051b;

    static {
        f8050a = new b();
    }

    private b() {
    }

    @Override // com.obric.memorydata.ability.k
    public void a(h r9) {
        h r8 = (h) ZeusTransformUtils.wrapperContextForParams(r9, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "data");
        if (ZeusTransformUtils.instanceOf(r8, p.class) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r8, p.class, "com.obric.memorydata.plugin")).a(), "unlock") == false) goto L11;
        long r10 = System.currentTimeMillis();
        if ((r10 - f8051b) < 1800000) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifeLogTrigger", "unlock invoke life log", false, 4, null);
        f8051b = r10;
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("life_log_generate").setConditions(new Condition[]{Condition.SCREEN_ON_OR_CHARGE, Condition.NETWORK_AVAILABLE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        return;
    L12:
        return;
    }

    public final void b() {
        boolean r0 = ((Boolean) ZeusTransformUtils.preCheckCast(RecommendApi.INSTANCE.screenObservationEnabled().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (DeviceInfoState.INSTANCE.isObricOsDevice() == false) goto L8;
        if (r0 == false) goto L9;
        new d().a(new f(100000005, MapsKt.mapOf(TuplesKt.to("mode", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL))), (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        return;
    }

    @Override // com.obric.memorydata.ability.k
    public String g_() {
        return k.a.a(this);
    }
}
