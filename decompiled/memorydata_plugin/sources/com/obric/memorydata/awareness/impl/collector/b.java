package com.obric.memorydata.awareness.impl.collector;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J0\u0010\u0007\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\n\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/awareness/impl/collector/AssistantWakeupFeatureCollector;", "Lcom/obric/memorydata/awareness/impl/collector/FeatureCollector;", "<init>", "()V", "startCollect", "", "stopCollect", "queryFeatureAndExtra", "Lkotlin/Pair;", "", "", "", "featureName", "onChange", "isWakeup", "", InfoRequestQPSOptTraceLogger.REASON, "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends e {
    public b() {
    }

    public static final /* synthetic */ void a(b r0, boolean r1, String r2) {
        r0.a(r1, r2);
    }

    private final void a(boolean r9, String r10) {
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "device_is_assistant_wakeup", Boolean.valueOf(r9), null, 4, null);
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "device_assistant_wakeup_reason", r10, null, 4, null);
    }

    @Override // com.obric.memorydata.awareness.impl.collector.e
    public Pair<Object, Map<String, Object>> a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        if (Intrinsics.areEqual(r2, "device_is_assistant_wakeup") == false) goto L8;
        Object r1 = Boolean.valueOf(com.obric.memorydata.awareness.impl.a.f8618a.b());
    L6:
        return TuplesKt.to(r1, null);
    L8:
        if (Intrinsics.areEqual(r2, "device_assistant_wakeup_reason") == false) goto L10;
        r1 = com.obric.memorydata.awareness.impl.a.f8618a.a();
        goto L6
    L10:
        return null;
    }

    @Override // com.obric.memorydata.awareness.impl.collector.e
    public void b() {
        super.b();
        com.obric.memorydata.awareness.impl.a.f8618a.a((Function2) ZeusTransformUtils.preCheckCast(new AssistantWakeupFeatureCollector$startCollect$1(this), Function2.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.awareness.impl.collector.e
    public void c() {
        super.c();
        com.obric.memorydata.awareness.impl.a.f8618a.b((Function2) ZeusTransformUtils.preCheckCast(new AssistantWakeupFeatureCollector$stopCollect$1(this), Function2.class, "com.obric.memorydata.plugin"));
    }
}
