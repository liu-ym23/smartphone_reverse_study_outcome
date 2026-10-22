package com.obric.assistant.state.impl.multitask.producer;

import aha.n;
import aha.o;
import com.obric.assistant.state.api.multitask.producer.IObricInteractionStateProducerService;
import com.obric.assistant.state.api.multitask.state.ObricInteractionStateType;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import java.util.LinkedHashMap;
import java.util.Map;
import jha.f;
import jha.g;
import jha.j;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016J.\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017H\u0016J.\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J,\u0010\u001b\u001a\u00020\u00112\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/ObricInteractionStateProducer;", "Lcom/obric/assistant/state/multitask/core/TaskFlowStateProducer;", "Lcom/obric/assistant/state/api/multitask/producer/IObricInteractionStateProducerService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activeInteractions", "", "Lcom/obric/assistant/state/multitask/core/TaskFlowId;", "Lcom/obric/assistant/state/api/multitask/state/ObricInteractionState;", "Lcom/obric/assistant/state/impl/multitask/producer/ObricInteractionStateProducer$ActiveInteraction;", "interactionsLock", "Lkotlinx/coroutines/sync/Mutex;", "dispatchPolicy", "Lcom/obric/assistant/state/multitask/core/TaskFlowDispatchPolicy;", "activateInteraction", "", "ownerId", "", "interactionType", "Lcom/obric/assistant/state/api/multitask/state/ObricInteractionStateType;", "ext", "", "", "deactivateInteraction", "clearInteractions", "endInteraction", "taskId", "ActiveInteraction", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricInteractionStateProducer implements j, IObricInteractionStateProducerService {
    public final CoroutineScope a;
    public final Map<g<n>, a> b;
    public final MutexImpl c;

    public static final class a {
        public final String a;
        public final ObricInteractionStateType b;
        public final jha.l<n> c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "ActiveInteraction(ownerId=" + this.a + ", interactionType=" + this.b + ", handle=" + this.c + ')';
        }

        public a(String r2, ObricInteractionStateType r3, jha.l<n> r4) {
            Intrinsics.checkNotNullParameter(r2, "ownerId");
            Intrinsics.checkNotNullParameter(r3, "interactionType");
            Intrinsics.checkNotNullParameter(r4, "handle");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public ObricInteractionStateProducer() {
        this.a = f.b;
        this.b = new LinkedHashMap();
        this.c = b.a();
    }

    @Override // com.obric.assistant.state.api.multitask.producer.IObricInteractionStateProducerService
    public final void a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "ownerId");
        if (StringsKt.isBlank(r8) == false) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this.a, null, CoroutineStart.UNDISPATCHED, new ObricInteractionStateProducer$clearInteractions$1(this, r8, null), 1, null);
    }

    public static final void d(ObricInteractionStateProducer r2, g r3, Map r4) {
        a r5 = r2.b.remove(r3);
        if (r5 == null) goto L7;
        TaskFlowDslKt.c(r5.c, new n.b(r5.a, r5.b, r4));
        return;
    }

    @Override // com.obric.assistant.state.api.multitask.producer.IObricInteractionStateProducerService
    public final void b(String r12, ObricInteractionStateType r13, Map<String, ? extends Object> r14) {
        Intrinsics.checkNotNullParameter(r12, "ownerId");
        Intrinsics.checkNotNullParameter(r13, "interactionType");
        Intrinsics.checkNotNullParameter(r14, "ext");
        if (StringsKt.isBlank(r12) == false) goto L5;
        return;
    L5:
        n.a r4 = new n.a(r12, r13, MapsKt.toMap(r14));
        g<n> r3 = o.a(r12, r13);
        BuildersKt.launch$default(this.a, null, CoroutineStart.UNDISPATCHED, new ObricInteractionStateProducer$activateInteraction$1(this, r3, r4, r12, r13, null), 1, null);
    }

    @Override // com.obric.assistant.state.api.multitask.producer.IObricInteractionStateProducerService
    public final void c(String r7, ObricInteractionStateType r8, Map<String, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r7, "ownerId");
        Intrinsics.checkNotNullParameter(r8, "interactionType");
        Intrinsics.checkNotNullParameter(r9, "ext");
        if (StringsKt.isBlank(r7) == false) goto L5;
        return;
    L5:
        Map r10 = MapsKt.toMap(r9);
        g<n> r11 = o.a(r7, r8);
        BuildersKt.launch$default(this.a, null, CoroutineStart.UNDISPATCHED, new ObricInteractionStateProducer$deactivateInteraction$1(this, r11, r10, null), 1, null);
    }
}
