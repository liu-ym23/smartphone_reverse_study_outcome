package com.larus.canvas.feature.component.base;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.canvas.feature.component.base.b;
import com.larus.canvas.feature.component.base.c;
import com.larus.canvas.feature.component.base.d;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\u00020\u00072\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00050\bB\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u001d\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001eJ!\u0010\u001f\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\"¢\u0006\u0002\b#H\u0016J\u0015\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00028\u0002H\u0004¢\u0006\u0002\u0010&J\u0015\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010)R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00020\u0014X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/larus/canvas/feature/component/base/AbsUIComponent;", "S", "Lcom/larus/canvas/feature/component/base/IUIState;", "E", "Lcom/larus/canvas/feature/component/base/IUIEvent;", "A", "Lcom/larus/canvas/feature/component/base/IUIAction;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/canvas/feature/component/base/IUIAbility;", "<init>", "()V", "_uiStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "get_uiStateFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "uiStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getUiStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "uiEventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getUiEventFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "_uiActionFlow", "get_uiActionFlow", "uiActionFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiActionFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "initialState", "()Lcom/larus/canvas/feature/component/base/IUIState;", "refreshUIState", "", "reducer", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "emitUIAction", "action", "(Lcom/larus/canvas/feature/component/base/IUIAction;)V", "sendUIEvent", "event", "(Lcom/larus/canvas/feature/component/base/IUIEvent;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsUIComponent<S extends d, E extends c, A extends b> extends BaseContentWidget implements a<S, E, A> {
    public final StateFlowImpl m;
    public final b1 n;
    public final MutableSharedFlow<E> o;
    public final MutableSharedFlow<A> p;
    public final a1 q;

    public abstract S h3();

    public AbsUIComponent() {
        StateFlowImpl r0 = j1.a(h3());
        this.m = r0;
        this.n = e.b(r0);
        this.o = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        MutableSharedFlow<A> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.p = r1;
        this.q = e.a(r1);
    }

    @Override // com.larus.canvas.feature.component.base.a
    public final a1 U4() {
        return this.q;
    }

    @Override // com.larus.canvas.feature.component.base.a
    public final i1<S> lb() {
        return this.n;
    }

    @Override // com.larus.canvas.feature.component.base.a
    public final void N50(Function1<? super S, ? extends S> r3) {
        Intrinsics.checkNotNullParameter(r3, "reducer");
        StateFlowImpl r0 = this.m;
        r0.setValue(r3.invoke(r0.getValue()));
    }

    public final void Y2(A r8) {
        Intrinsics.checkNotNullParameter(r8, "action");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AbsUIComponent$emitUIAction$1(this, r8, null), 3, null);
    }

    @Override // com.larus.canvas.feature.component.base.a
    public void yS(E r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AbsUIComponent$sendUIEvent$1(this, r8, null), 3, null);
    }
}
