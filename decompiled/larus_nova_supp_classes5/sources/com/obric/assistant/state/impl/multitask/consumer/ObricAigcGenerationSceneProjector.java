package com.obric.assistant.state.impl.multitask.consumer;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.multitask.IObricTaskFlowActiveStateService;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandPriority;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer;
import hha.a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import jha.o;
import jha.p;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import zga.d;
import zga.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J0\u0010\n\u001a\u00020\t2\u0014\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\f2\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\rH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/consumer/ObricAigcGenerationSceneProjector;", "Lcom/obric/assistant/state/multitask/core/TaskFlowAutoInitProducer;", "Lcom/obric/assistant/state/api/multitask/ObricTaskFlowActiveStateObserver;", "<init>", "()V", "activeConversations", "", "", "initProducer", "", "onActiveStatesChanged", "activeStates", "", "Lcom/obric/assistant/state/multitask/core/TaskStateEnvelope;", "Lcom/obric/assistant/state/multitask/core/TaskState;", "changedState", "dispatch", "conversationId", "state", "Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandStateType;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAigcGenerationSceneProjector implements TaskFlowAutoInitProducer, e {
    public static final /* synthetic */ int b = 0;
    public final Set<String> a;

    static {
    }

    @Override // com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer
    public final void f() {
        Lazy r0 = zga.g.a;
        d r1 = new g();
        Intrinsics.checkNotNullParameter(this, "observer");
        Intrinsics.checkNotNullParameter(r1, "filter");
        ((IObricTaskFlowActiveStateService) zga.g.a.getValue()).c(this, r1);
    }

    public ObricAigcGenerationSceneProjector() {
        this.a = new LinkedHashSet();
    }

    public static void b(String r11, ObricIslandStateType r12) {
        FLogger.a.i("ObricAigcSceneProjector", "dispatch state=" + r12 + ", conversationId=" + r11);
        a r0 = com.obric.assistant.state.impl.v2.core.g.a;
        com.obric.assistant.state.impl.v2.core.g.a(new ObricState(r12, r11, ObricInteractionScene.AIGC_GENERATION_SCENE, ObricIslandPriority.LOW, null, null, null, 112, null));
    }

    @Override // zga.e
    public final void a(List<? extends p<? extends o>> r4, p<? extends o> r5) {
        Intrinsics.checkNotNullParameter(r4, "activeStates");
        LinkedHashSet r6 = new LinkedHashSet();
        Iterator<T> r7 = r4.iterator();
    L4:
        if (r7.hasNext() == false) goto L13;
        aha.g.a r0 = ((p) r7.next()).b;
        String r2 = null;
        if ((r0 instanceof aha.g.a) == false) goto L8;
        aha.g.a r1 = r0;
    L9:
        if (r1 == null) goto L11;
        r2 = r1.g;
    L11:
        if (r2 == null) goto L4;
        r6.add(r2);
        goto L4
    L8:
        r1 = null;
        goto L9
    L13:
        Set<String> r8 = this.a;
        monitor-enter(r8);
        Set r3 = SetsKt.minus(r6, this.a);     // Catch: Throwable -> L26
        Set r9 = SetsKt.minus(this.a, r6);     // Catch: Throwable -> L26
        this.a.clear();     // Catch: Throwable -> L26
        this.a.addAll(r6);     // Catch: Throwable -> L26
        monitor-exit(r8);
        Iterator r10 = r3.iterator();
    L19:
        if (r10.hasNext() == false) goto L21;
        b((String) r10.next(), ObricIslandStateType.DEEP_THINK_START);
        goto L19
    L21:
        Iterator r11 = r9.iterator();
    L23:
        if (r11.hasNext() == false) goto L25;
        b((String) r11.next(), ObricIslandStateType.DEEP_THINK_END);
        goto L23
    L25:
        return;
    L26:
        th = move-exception;
        throw th;
    }
}
