package com.larus.platform.audit;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/platform/audit/DefaultFlowBehaviorAuditServiceImpl;", "Lcom/larus/platform/audit/IFlowBehaviorAuditService;", "<init>", "()V", "auditEvent", "", "event", "Lcom/larus/platform/audit/BehaviorAuditEvent;", "init", "api", "", "clearInit", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DefaultFlowBehaviorAuditServiceImpl implements IFlowBehaviorAuditService {
    public DefaultFlowBehaviorAuditServiceImpl() {
    }

    @Override // com.larus.platform.audit.IFlowBehaviorAuditService
    public final void a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.platform.audit.IFlowBehaviorAuditService
    public final void b() {
    }

    @Override // com.larus.platform.audit.IFlowBehaviorAuditService
    public final void init(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "api");
    }
}
