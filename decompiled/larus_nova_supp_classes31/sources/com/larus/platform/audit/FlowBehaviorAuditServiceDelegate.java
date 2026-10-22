package com.larus.platform.audit;

import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/larus/platform/audit/FlowBehaviorAuditServiceDelegate;", "Lcom/larus/platform/audit/IFlowBehaviorAuditService;", "<init>", "()V", "service", "getService", "()Lcom/larus/platform/audit/IFlowBehaviorAuditService;", "service$delegate", "Lkotlin/Lazy;", "init", "", "api", "", "auditEvent", "event", "Lcom/larus/platform/audit/BehaviorAuditEvent;", "clearInit", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class FlowBehaviorAuditServiceDelegate implements IFlowBehaviorAuditService {
    public static final FlowBehaviorAuditServiceDelegate a = null;
    public static final Lazy b = null;

    private FlowBehaviorAuditServiceDelegate() {
    }

    static {
        a = new FlowBehaviorAuditServiceDelegate();
        b = LazyKt.lazy(new c());
    }

    @Override // com.larus.platform.audit.IFlowBehaviorAuditService
    public final void b() {
        IFlowBehaviorAuditService r0 = (IFlowBehaviorAuditService) b.getValue();
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.larus.platform.audit.IFlowBehaviorAuditService
    public final void a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        IFlowBehaviorAuditService r0 = (IFlowBehaviorAuditService) b.getValue();
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // com.larus.platform.audit.IFlowBehaviorAuditService
    public final void init(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "api");
        IFlowBehaviorAuditService r0 = (IFlowBehaviorAuditService) b.getValue();
        if (r0 == null) goto L6;
        r0.init(r2);
        return;
    }
}
