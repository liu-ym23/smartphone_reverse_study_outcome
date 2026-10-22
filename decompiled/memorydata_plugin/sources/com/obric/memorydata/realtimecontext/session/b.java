package com.obric.memorydata.realtimecontext.session;

import android.app.assist.AssistStructure;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.realtimecontext.RealTimeContextService;
import com.obric.memorydata.sdk.assistant.QueryType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J4\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/realtimecontext/session/RealTimeContextCloudProcessor;", "Lcom/obric/memorydata/realtimecontext/session/AbsRealTimeContextProcessor;", "dispatcher", "Lcom/obric/memorydata/realtimecontext/RealTimeContextService;", "<init>", "(Lcom/obric/memorydata/realtimecontext/RealTimeContextService;)V", "realTimeData", "Lcom/obric/memorydata/realtimecontext/session/RealTimeDataForCloud;", "onHandleAssistWithCallback", "", "assistStructure", "Landroid/app/assist/AssistStructure;", "entities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "callback", "Lcom/obric/memorydata/sdk/realtime/IRealTimeContextCallback;", "actionContextStartMs", "", "onHandleQuery", "queryType", "Lcom/obric/memorydata/sdk/assistant/QueryType;", "provideRealTimeData", "Lcom/obric/memorydata/realtimecontext/session/RealTimeData;", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f12482a;

    public b(RealTimeContextService r2) {
        Intrinsics.checkNotNullParameter(r2, "dispatcher");
        super(r2);
        this.f12482a = new d();
    }

    @Override // com.obric.memorydata.realtimecontext.session.a, com.obric.memorydata.sdk.realtime.b
    public void a(AssistStructure r10, List<AppEntity> r11, com.obric.memorydata.sdk.realtime.a r12) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.sdk.realtime.a r13 = (com.obric.memorydata.sdk.realtime.a) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.memorydata.sdk.realtime.a.class, "com.obric.memorydata.plugin");
        this.f12482a.a(r13);
        RealTimeContextService.dispatchAssist$realtime_context_obricRelease$default(a(), r10, r4, 0, 4, null);
    }

    @Override // com.obric.memorydata.realtimecontext.session.a
    public void a(AssistStructure r3, List<AppEntity> r4, com.obric.memorydata.sdk.realtime.a r5, long r6) {
        List<? extends AppEntity> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.sdk.realtime.a r8 = (com.obric.memorydata.sdk.realtime.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.memorydata.sdk.realtime.a.class, "com.obric.memorydata.plugin");
        this.f12482a.a(r8);
        a().dispatchAssist$realtime_context_obricRelease(r3, r7, r6);
    }

    @Override // com.obric.memorydata.realtimecontext.session.a
    public void a(QueryType r3) {
        Intrinsics.checkNotNullParameter(r3, "queryType");
        a().getOnScreenTracker$realtime_context_obricRelease().a(System.currentTimeMillis(), r3.ordinal());
    }

    @Override // com.obric.memorydata.realtimecontext.session.a
    public c b() {
        return (c) ZeusTransformUtils.preCheckCast(this.f12482a, c.class, "com.obric.memorydata.plugin");
    }
}
