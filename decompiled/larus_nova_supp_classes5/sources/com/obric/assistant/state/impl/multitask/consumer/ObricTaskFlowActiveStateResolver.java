package com.obric.assistant.state.impl.multitask.consumer;

import aha.m;
import aha.x;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.multitask.core.TaskFlowCriticalResolver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jha.h;
import jha.o;
import jha.p;
import jha.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0096@¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/consumer/ObricTaskFlowActiveStateResolver;", "Lcom/obric/assistant/state/multitask/core/TaskFlowCriticalResolver;", "<init>", "()V", "stateReceiver", "Lcom/obric/assistant/state/impl/multitask/consumer/TaskFlowActiveStateReceiver;", "resolve", "", "id", "Lcom/obric/assistant/state/multitask/core/TaskFlowId;", "taskStateEvent", "Lcom/obric/assistant/state/multitask/core/TaskStateEvent;", "(Lcom/obric/assistant/state/multitask/core/TaskFlowId;Lcom/obric/assistant/state/multitask/core/TaskStateEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTaskFlowActiveStateResolver implements TaskFlowCriticalResolver {
    public final TaskFlowActiveStateStore a;

    public ObricTaskFlowActiveStateResolver() {
        this.a = h.a;
    }

    public final Unit a(jha.g r17, q r18) {
        if (r17.getType() == m.a) goto L68;
        if (r17.getType() == x.a) goto L68;
        p<? extends o> r7 = r18.a();
        boolean r1 = r7.b.a() instanceof h.a;
        TaskFlowActiveStateStore r9 = this.a;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r17, "taskFlowId");
        Intrinsics.checkNotNullParameter(r7, "changedState");
        Object r10 = r9.b;
        monitor-enter(r10);
        Object r3 = r9.a;     // Catch: Throwable -> L64
        monitor-enter(r3);     // Catch: Throwable -> L64
        p<? extends o> r11 = r9.c.get(r17);     // Catch: Throwable -> L61
        if (r1 == false) goto L14;
        p<? extends o> r12 = r7;
    L16:
        if (r12 == null) goto L21;
        if (Intrinsics.areEqual(r9.c.put(r17, r12), r12) == false) goto L22;
    L23:
        boolean r2 = false;
    L24:
        if (r2 == true) goto L28;
        monitor-exit(r3);     // Catch: Throwable -> L64
        monitor-exit(r10);
    L60:
        return Unit.INSTANCE;
    L28:
        List r15 = CollectionsKt.toList(r9.d.values());     // Catch: Throwable -> L61
        int r4 = r9.c.size();     // Catch: Throwable -> L61
        Intrinsics.checkNotNullParameter(r15, "registrations");     // Catch: Throwable -> L61
        monitor-exit(r3);     // Catch: Throwable -> L64
        FLogger.a.i("ObricTaskFlowActiveState", "aggregate_changed taskFlowId=" + r17 + ",state=" + r7.b.getClass().getSimpleName() + ",lifecycle=" + r7.b.a().getClass().getSimpleName() + ",activeCount=" + r4);     // Catch: Throwable -> L64
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L64
        Iterator r6 = r15.iterator();     // Catch: Throwable -> L64
    L32:
        if (r6.hasNext() == false) goto L40;
        Object r8 = r6.next();     // Catch: Throwable -> L64
        if (((TaskFlowActiveStateStore.c) r8).c != TaskFlowActiveStateStore.DispatchMode.ASYNC) goto L36;
        boolean r13 = true;
    L37:
        if (r13 == false) goto L32;
        r5.add(r8);     // Catch: Throwable -> L64
        goto L32
    L36:
        r13 = false;
        goto L37
    L40:
        if ((!r5.isEmpty()) == false) goto L44;
        Object r14 = r9.f.mo530trySendJP2dKIU(new TaskFlowActiveStateStore.a.b(r5, r17, r11, r12, r7));     // Catch: Throwable -> L64
        kotlinx.coroutines.channels.g.c r16 = kotlinx.coroutines.channels.g.b;     // Catch: Throwable -> L64
        if ((r14 instanceof kotlinx.coroutines.channels.g.c) == false) goto L44;
        FLogger.a.e("ObricTaskFlowActiveState", "enqueue async observer command failed,command=".concat(TaskFlowActiveStateStore.a.b.class.getSimpleName()));     // Catch: Throwable -> L64
    L44:
        ArrayList r19 = new ArrayList();     // Catch: Throwable -> L64
        Iterator r20 = r15.iterator();     // Catch: Throwable -> L64
    L46:
        if (r20.hasNext() == false) goto L53;
        Object r21 = r20.next();     // Catch: Throwable -> L64
        if (((TaskFlowActiveStateStore.c) r21).c != TaskFlowActiveStateStore.DispatchMode.SYNC) goto L50;
        boolean r22 = true;
    L51:
        if (r22 == false) goto L46;
        r19.add(r21);     // Catch: Throwable -> L64
        goto L46
    L50:
        r22 = false;
        goto L51
    L53:
        Iterator r110 = r19.iterator();     // Catch: Throwable -> L64
    L55:
        if (r110.hasNext() == false) goto L57;
        r9.g((TaskFlowActiveStateStore.c) r110.next(), r17, r11, r12, r7);     // Catch: Throwable -> L64
        goto L55
    L57:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L64
        monitor-exit(r10);
        goto L60
    L22:
        r2 = true;
        goto L24
    L21:
        if (r9.c.remove(r17) == null) goto L23;
    L14:
        r12 = null;
    L61:
        th = move-exception;
        throw th;     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        throw th;
    L68:
        return Unit.INSTANCE;
    }
}
