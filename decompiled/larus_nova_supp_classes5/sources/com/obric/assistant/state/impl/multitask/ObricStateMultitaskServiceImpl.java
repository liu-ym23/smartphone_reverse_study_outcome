package com.obric.assistant.state.impl.multitask;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.multitask.IObricInteractionModeService;
import com.obric.assistant.state.api.multitask.IObricInteractionProjectionService;
import com.obric.assistant.state.api.multitask.IObricStateMultitaskService;
import com.obric.assistant.state.multitask.TaskFlowManager;
import com.obric.assistant.state.multitask.b;
import com.obric.assistant.state.multitask.c;
import com.obric.assistant.state.multitask.core.TaskFlowAsyncObserver;
import com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer;
import com.obric.assistant.state.multitask.core.TaskFlowCriticalResolver;
import com.obric.assistant.state.multitask.core.TaskFlowInterceptor;
import com.obric.assistant.state.multitask.internal.engine.TaskFlowPolicyEngine;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/ObricStateMultitaskServiceImpl;", "Lcom/obric/assistant/state/api/multitask/IObricStateMultitaskService;", "<init>", "()V", "TAG", "", "initialized", "", "initMultitask", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricStateMultitaskServiceImpl implements IObricStateMultitaskService {
    public final String a;
    public volatile boolean b;

    public static final class a implements b {
        public final /* synthetic */ ObricStateMultitaskServiceImpl b;

        public final boolean isEnabled() {
            return true;
        }

        public a(ObricStateMultitaskServiceImpl r1) {
            this.b = r1;
        }

        public final void a(com.obric.assistant.state.multitask.a r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            FLogger.a.i(this.b.a + r4.a, String.valueOf(r4));
        }

        public final void b(com.obric.assistant.state.multitask.a r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            FLogger.a.e(this.b.a + r4.a, String.valueOf(r4));
        }
    }

    public final void a() {
        if (this.b == false) goto L5;
        return;
    L5:
        this.b = true;
        TaskFlowManager r0 = TaskFlowManager.a;
        c.a = new a(this);
        ServiceManager.get().getService(IObricInteractionModeService.class);
        ServiceManager.get().getService(IObricInteractionProjectionService.class);
        Iterator r1 = ServiceManager.get().getServices(TaskFlowInterceptor.class).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        TaskFlowInterceptor r2 = (TaskFlowInterceptor) r1.next();
        TaskFlowPolicyEngine r3 = TaskFlowManager.c;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        r3.a.add(r2);
        goto L7
    L9:
        Iterator r4 = ServiceManager.get().getServices(TaskFlowCriticalResolver.class).iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        TaskFlowCriticalResolver r5 = (TaskFlowCriticalResolver) r4.next();
        TaskFlowPolicyEngine r6 = TaskFlowManager.c;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "resolver");
        r6.b.add(r5);
        goto L11
    L13:
        Iterator r7 = ServiceManager.get().getServices(TaskFlowAsyncObserver.class).iterator();
    L15:
        if (r7.hasNext() == false) goto L17;
        TaskFlowAsyncObserver r8 = (TaskFlowAsyncObserver) r7.next();
        TaskFlowPolicyEngine r9 = TaskFlowManager.c;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r8, "observer");
        r9.c.add(r8);
        goto L15
    L17:
        Iterator r10 = ServiceManager.get().getServices(TaskFlowAutoInitProducer.class).iterator();
    L19:
        if (r10.hasNext() == false) goto L21;
        ((TaskFlowAutoInitProducer) r10.next()).f();
        goto L19
    }

    public ObricStateMultitaskServiceImpl() {
        this.a = "ObricMultitask_";
    }
}
