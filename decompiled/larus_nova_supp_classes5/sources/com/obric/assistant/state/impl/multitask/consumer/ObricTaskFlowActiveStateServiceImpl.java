package com.obric.assistant.state.impl.multitask.consumer;

import com.obric.assistant.state.api.multitask.IObricTaskFlowActiveStateService;
import com.obric.assistant.util.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zga.d;
import zga.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u00052\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J!\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000bH\u0096\u0001J!\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0001¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/consumer/ObricTaskFlowActiveStateServiceImpl;", "Lcom/obric/assistant/state/api/multitask/IObricTaskFlowActiveStateService;", "<init>", "()V", "getActiveStates", "", "Lcom/obric/assistant/state/multitask/core/TaskStateEnvelope;", "Lcom/obric/assistant/state/multitask/core/TaskState;", "filter", "Lcom/obric/assistant/state/api/multitask/ObricTaskFlowActiveStateFilter;", "isActive", "", "registerObserver", "", "observer", "Lcom/obric/assistant/state/api/multitask/ObricTaskFlowActiveStateObserver;", "sticky", "registerSyncObserver", "unregisterObserver", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTaskFlowActiveStateServiceImpl implements IObricTaskFlowActiveStateService {
    public final /* synthetic */ TaskFlowActiveStateStore a;

    public final void a(e r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.a.a(r2);
    }

    public final boolean b(r r2) {
        Intrinsics.checkNotNullParameter(r2, "filter");
        return this.a.b(r2);
    }

    public final void c(e r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        Intrinsics.checkNotNullParameter(r3, "filter");
        this.a.c(r2, r3);
    }

    public ObricTaskFlowActiveStateServiceImpl() {
        this.a = h.a;
    }
}
