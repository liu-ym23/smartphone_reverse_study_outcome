package com.larus.bmhome.chat.component.halfscreen;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;
import s1a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010\u001a\u001a\u00020\u00132\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00130\u001cH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/chat/component/halfscreen/ChatPageStateComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/bmhome/chat/component/halfscreen/IChatPageStateAbility;", "<init>", "()V", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "_screenState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/bmhome/chat/component/halfscreen/ScreenState;", "screenState", "Lkotlinx/coroutines/flow/StateFlow;", "getScreenState", "()Lkotlinx/coroutines/flow/StateFlow;", "onAttach", "", "onCreate", "onParentViewCreated", "isFullScreen", "", "setFullScreen", "setScreenState", "onScreenStateChanged", "action", "Lkotlin/Function1;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatPageStateComponent extends ComponentFeature implements c {
    public final Lazy h;
    public final StateFlowImpl i;
    public final b1 j;

    public static final class a {
    }

    public static final class b implements Function0<de8.c> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).g(Reflection.getOrCreateKotlinClass(de8.c.class));
        }
    }

    static {
    }

    public final void B2() {
    }

    @Override // com.larus.bmhome.chat.component.halfscreen.c
    public final boolean isFullScreen() {
        if (this.j.getValue() == ScreenState.FULL) goto L5;
    L7:
        return false;
    L5:
        if (this.j.getValue() == ScreenState.UNINITIALIZED) goto L7;
        return true;
    }

    public final void onCreate() {
        de8.c r0 = (de8.c) this.h.getValue();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.n() != true) goto L7;
    L8:
        if (r1 == false) goto L10;
        ScreenState r2 = ScreenState.HALF;
    L11:
        this.i.setValue(r2);
        return;
    L10:
        r2 = ScreenState.FULL;
    L7:
        r1 = false;
        goto L8
    }

    public ChatPageStateComponent() {
        this.h = LazyKt.lazy(new b(this));
        StateFlowImpl r0 = j1.a(ScreenState.UNINITIALIZED);
        this.i = r0;
        this.j = e.b(r0);
    }

    public final void y2() {
        s1a.a.b(s1a.a.getActivity(this), this, c.class);
    }

    @Override // com.larus.bmhome.chat.component.halfscreen.c
    public final void UX(Function1<? super Boolean, Unit> r8) {
        Intrinsics.checkNotNullParameter(r8, "action");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatPageStateComponent$onScreenStateChanged$1(this, r8, null), 3, null);
    }

    @Override // com.larus.bmhome.chat.component.halfscreen.c
    public final void dN(ScreenState r8) {
        Intrinsics.checkNotNullParameter(r8, "screenState");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatPageStateComponent$setScreenState$1(this, r8, null), 3, null);
    }
}
